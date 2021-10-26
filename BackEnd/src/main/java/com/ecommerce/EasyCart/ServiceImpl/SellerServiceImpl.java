/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.ServiceImpl;

import java.util.Collection;
import static com.ecommerce.EasyCart.Security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.ecommerce.EasyCart.Forms.SellerForm;
import com.ecommerce.EasyCart.Forms.SellerLoginForm;

import com.ecommerce.EasyCart.Repository.SellerRepository;
import com.ecommerce.EasyCart.Security.Config.SecurityConfig;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator;
import com.ecommerce.EasyCart.Service.SellerService;
import com.ecommerce.EasyCart.View.SellerView;
import com.ecommerce.EasyCart.View.SellerLogin;

import com.ecommerce.EasyCart.Entity.Seller;
import com.ecommerce.EasyCart.Exception.BadRequestException;
import com.ecommerce.EasyCart.Security.Util.InvalidTokenException;
import com.ecommerce.EasyCart.Security.Util.TokenExpiredException;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator.Status;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator.Token;
import com.ecommerce.EasyCart.ServiceImpl.SellerServiceImpl;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import com.ecommerce.EasyCart.Security.Util.SecurityUtil;
import java.util.Optional;

/**
 *
 * @author anjana
 */
@Service

public class SellerServiceImpl implements SellerService{
     private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";
	  
	  @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    private SellerRepository sellerRepository;

	    @Autowired
	    private TokenGenerator tokenGenerator;

	    @Autowired
	    private SecurityConfig securityConfig;
	    
     
      @Override
	    public SellerView add(SellerForm form) {
	        return new SellerView(sellerRepository.save(new Seller(
                        form.getFirstName(),
                        form.getAddress(),
                        form.getCity(),
                        form.getState(),
                        form.getPin(),
                        form.getCountry(),

                        form.getPhone(),
                        form.getEmail(),
                        passwordEncoder.encode(form.getPassword()),
                form.getImage(),
                form.getFilename()
                )));
	             
	       
	    }
            @Override
    public SellerView currentSeller() {
        return new SellerView(
                sellerRepository.findById(SecurityUtil.getCurrentCustomerId()).orElseThrow(NotFoundException::new)
        );
    }
     @Override
            public Seller getSeller()
            {
                 
	        	return	sellerRepository.findBySellerId(SecurityUtil.getCurrentCustomerId());
	        
            }
             @Override
	    public SellerLogin login(SellerLoginForm form, Errors errors) throws BadRequestException {
	        if (errors.hasErrors()) {
	            throw new BadRequestException();
	        }
	        Seller seller = sellerRepository.findByEmail(form.getEmail()).orElseThrow(SellerServiceImpl::badRequestException);
	        if (!passwordEncoder.matches(form.getPassword(), seller.getPassword())) {
	            throw  new BadRequestException();
	        }

	        String id = String.format("%010d", seller.getSellerId());
	        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
	        Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + seller.getPassword(), securityConfig.getRefreshTokenExpiry());
	        return new SellerLogin(seller, accessToken, refreshToken);
	    }
            @Override
	    public SellerLogin refresh(String refreshToken) throws BadRequestException {
	        Status status;
	        try {
	            status = tokenGenerator.verify(PURPOSE_REFRESH_TOKEN, refreshToken);
	        } catch (InvalidTokenException e) {
	            throw new BadRequestException("Invalid token", e);
	        } catch (TokenExpiredException e) {
	            throw new BadRequestException("Token expired", e);
	        }

	        int sellerId;
	        try {
	        	sellerId = Integer.parseInt(status.data.substring(0, 10));
	        } catch (NumberFormatException e) {
	            throw new BadRequestException("Invalid token", e);
	        }

	        String password = status.data.substring(10);

	        Seller seller = sellerRepository.findBySellerIdAndPassword(sellerId, password).orElseThrow(BadRequestException::new);

	        String id = String.format("%010d", seller.getSellerId());
	        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
	        return new SellerLogin(
	                seller,
	                new SellerLogin.TokenView(accessToken.value, accessToken.expiry),
	                new SellerLogin.TokenView(refreshToken, status.expiry)
	        );
	    }
              @Override
	    @Transactional
	    public void delete(Integer sellerId) throws NotFoundException{
	    	sellerRepository.delete(sellerRepository.findById(SecurityUtil.getCurrentCustomerId()).orElseThrow(NotFoundException::new));
	    }
	    private static BadRequestException badRequestException() {
	        return new BadRequestException("Invalid credentials");
	    }
             @Override
	    public Collection<Seller> list() {
	        return sellerRepository.findAll();
	    }
             @Override
		@Transactional 
	    public SellerView update(Integer sellerId, SellerForm form) throws NotFoundException {
	        return sellerRepository.findById(sellerId)
	                .map((seller) -> {
	                    return new SellerView(sellerRepository.save(seller.update(form)));
	                }).orElseThrow(NotFoundException::new);
	    }
           /* @Transactional 
	    public SellerView upload(Integer sellerId, SellerForm form) throws NotFoundException {
	        return sellerRepository.findById(sellerId)
	                .map((seller) -> {
	                    return new SellerView(sellerRepository.save(seller.upload(form)));
	                }).orElseThrow(NotFoundException::new);
	    }*/
           
}
