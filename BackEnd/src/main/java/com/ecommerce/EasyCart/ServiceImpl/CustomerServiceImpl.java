package com.ecommerce.EasyCart.ServiceImpl;

import static com.ecommerce.EasyCart.Security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Forms.CustomerForm;
import com.ecommerce.EasyCart.Repository.CustomerRepository;
import com.ecommerce.EasyCart.Security.Config.SecurityConfig;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator;
import com.ecommerce.EasyCart.Service.CustomerService;
import com.ecommerce.EasyCart.View.CustomerLoginView;
import com.ecommerce.EasyCart.View.CustomerView;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Exception.BadRequestException;
import com.ecommerce.EasyCart.Forms.CustomerLoginForm;
import com.ecommerce.EasyCart.Security.Util.InvalidTokenException;
import com.ecommerce.EasyCart.Security.Util.TokenExpiredException;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator.Status;
import com.ecommerce.EasyCart.Security.Util.TokenGenerator.Token;
import com.ecommerce.EasyCart.ServiceImpl.CustomerServiceImpl;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import com.ecommerce.EasyCart.Security.Util.SecurityUtil;
import java.util.Optional;



@Service
public class CustomerServiceImpl implements CustomerService {
	
	  private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";
	  
	  @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private TokenGenerator tokenGenerator;

	    @Autowired
	    private SecurityConfig securityConfig;
	    
	    @Override
	    public CustomerView add(CustomerForm form) {
	        return new CustomerView(customerRepository.save(new Customer(
	                form.getName(),
	                form.getEmail(),
	                passwordEncoder.encode(form.getPassword())
	        )));
	    }

	    @Override
	    public CustomerView currentCustomer() {
	        return new CustomerView(
	        		customerRepository.findById(SecurityUtil.getCurrentCustomerId()).orElseThrow(CustomerServiceImpl::badRequestException)
	        );
	    }
	    @Override
            public Customer getCustomer()
            {
                 
	        	return	customerRepository.findByCustomerId(SecurityUtil.getCurrentCustomerId());
	        
            }
	    @Override
	    public CustomerLoginView login(CustomerLoginForm form, Errors errors) throws BadRequestException {
	        if (errors.hasErrors()) {
	            throw new BadRequestException();
	        }
	        Customer customer = customerRepository.findByEmail(form.getEmail()).orElseThrow(CustomerServiceImpl::badRequestException);
	        if (!passwordEncoder.matches(form.getPassword(), customer.getPassword())) {
	            throw  new BadRequestException();
	        }

	        String id = String.format("%010d", customer.getCustomerId());
	        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
	        Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + customer.getPassword(), securityConfig.getRefreshTokenExpiry());
	        return new CustomerLoginView(customer, accessToken, refreshToken);
	    }

	    @Override
	    public CustomerLoginView refresh(String refreshToken) throws BadRequestException {
	        Status status;
	        try {
	            status = tokenGenerator.verify(PURPOSE_REFRESH_TOKEN, refreshToken);
	        } catch (InvalidTokenException e) {
	            throw new BadRequestException("Invalid token", e);
	        } catch (TokenExpiredException e) {
	            throw new BadRequestException("Token expired", e);
	        }

	        int customerId;
	        try {
	        	customerId = Integer.parseInt(status.data.substring(0, 10));
	        } catch (NumberFormatException e) {
	            throw new BadRequestException("Invalid token", e);
	        }

	        String password = status.data.substring(10);

	        Customer customer = customerRepository.findByCustomerIdAndPassword(customerId, password).orElseThrow(BadRequestException::new);

	        String id = String.format("%010d", customer.getCustomerId());
	        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
	        return new CustomerLoginView(
	                customer,
	                new CustomerLoginView.TokenView(accessToken.value, accessToken.expiry),
	                new CustomerLoginView.TokenView(refreshToken, status.expiry)
	        );
	    }
	    
	    @Override
	    @Transactional
	    public void delete(Integer customerId) throws NotFoundException{
	    	customerRepository.delete(customerRepository.findById(SecurityUtil.getCurrentCustomerId()).orElseThrow(NotFoundException::new));
	    }

	    private static BadRequestException badRequestException() {
	        return new BadRequestException("Invalid credentials");
	    }

	    @Override
	    public Collection<Customer> list() {
	        return customerRepository.findAll();
	    }
	    
	    
	   
	    //update
	    @Override
		@Transactional 
	    public CustomerView update(Integer customerId, CustomerForm form) throws NotFoundException {
	        return customerRepository.findById(customerId)
	                .map((customer) -> {
	                    return new CustomerView(customerRepository.save(customer.update(form)));
	                }).orElseThrow(NotFoundException::new);
	    }

   

}
