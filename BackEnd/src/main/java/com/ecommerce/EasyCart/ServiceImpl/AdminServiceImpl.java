/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.ServiceImpl;

import static com.ecommerce.EasyCart.Security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.ecommerce.EasyCart.Entity.Admin;
import com.ecommerce.EasyCart.Forms.AdminForm;
import com.ecommerce.EasyCart.Repository.AdminRepository;
import com.ecommerce.EasyCart.Security.Config.SecurityConfig;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator;
import com.ecommerce.EasyCart.Service.AdminService;
import com.ecommerce.EasyCart.View.AdminLoginView;
import com.ecommerce.EasyCart.View.AdminView;
import com.ecommerce.EasyCart.Exception.BadRequestException;
import com.ecommerce.EasyCart.Forms.AdminLoginForm;
import com.ecommerce.EasyCart.Security.Util.InvalidTokenException;
import com.ecommerce.EasyCart.Security.Util.TokenExpiredException;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator.Status;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator.Token;
import com.ecommerce.EasyCart.ServiceImpl.AdminServiceImpl;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import com.ecommerce.EasyCart.Security.Util.SecurityUtil;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;



@Service
public class AdminServiceImpl implements AdminService{
    
     private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";
	  
	  @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    private AdminRepository adminRepository;

	    @Autowired
	    private TokenGenerator tokenGenerator;

	    @Autowired
	    private SecurityConfig securityConfig;
	    
            @Override
    public AdminView add(AdminForm form) {
        return new AdminView(adminRepository.save(new Admin(
                form.getName(),
                form.getEmail(),
                passwordEncoder.encode(form.getPassword()),
                form.getImage(),
                form.getFilename()
        )));
    }
     @Override
    public AdminView currentAdmin() {
        return new AdminView(
                adminRepository.findById(SecurityUtil.getCurrentCustomerId()).orElseThrow(NotFoundException::new)
        );
    }
     @Override
            public Admin getAdmin()
            {
                 
	        	return	adminRepository.findByAdminId(SecurityUtil.getCurrentCustomerId());
	        
            }
    @Override
	    public AdminLoginView login(AdminLoginForm form, Errors errors) throws BadRequestException {
	        if (errors.hasErrors()) {
	            throw new BadRequestException();
	        }
	        Admin admin = adminRepository.findByEmail(form.getEmail()).orElseThrow(AdminServiceImpl::badRequestException);
	        if (!passwordEncoder.matches(form.getPassword(), admin.getPassword())) {
	            throw  new BadRequestException();
	        }

	        String id = String.format("%010d", admin.getAdminId());
	        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
	        Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + admin.getPassword(), securityConfig.getRefreshTokenExpiry());
	        return new AdminLoginView(admin, accessToken, refreshToken);
	    }
@Override
	    public AdminLoginView refresh(String refreshToken) throws BadRequestException {
	        Status status;
	        try {
	            status = tokenGenerator.verify(PURPOSE_REFRESH_TOKEN, refreshToken);
	        } catch (InvalidTokenException e) {
	            throw new BadRequestException("Invalid token", e);
	        } catch (TokenExpiredException e) {
	            throw new BadRequestException("Token expired", e);
	        }

	        int adminId;
	        try {
	        	adminId = Integer.parseInt(status.data.substring(0, 10));
	        } catch (NumberFormatException e) {
	            throw new BadRequestException("Invalid token", e);
	        }

	        String password = status.data.substring(10);

	        Admin admin = adminRepository.findByAdminIdAndPassword(adminId, password).orElseThrow(BadRequestException::new);

	        String id = String.format("%010d", admin.getAdminId());
	        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
	        return new AdminLoginView(
	                admin,
	                new AdminLoginView.TokenView(accessToken.value, accessToken.expiry),
	                new AdminLoginView.TokenView(refreshToken, status.expiry)
	        );
	    }
	    
	    @Override
	    @Transactional
	    public void delete(Integer adminId) throws NotFoundException{
	    	adminRepository.delete(adminRepository.findById(SecurityUtil.getCurrentCustomerId()).orElseThrow(NotFoundException::new));
	    }
	    private static BadRequestException badRequestException() {
	        return new BadRequestException("Invalid credentials");
	    }
            @Override
    public Collection<Admin> list() {
        return adminRepository.findAll();
    }
     @Override
		@Transactional 
	    public AdminView update(Integer adminId, AdminForm form) throws NotFoundException {
	        return adminRepository.findById(adminId)
	                .map((admin) -> {
	                    return new AdminView(adminRepository.save(admin.update(form
                            
               
                            )));
	                }).orElseThrow(NotFoundException::new);
	    }
        
         
}
                       

