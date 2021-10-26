package com.ecommerce.EasyCart.Service;

import java.util.Collection;

import org.springframework.validation.Errors;

import com.ecommerce.EasyCart.Forms.CustomerForm;
import com.ecommerce.EasyCart.Forms.CustomerLoginForm;
import com.ecommerce.EasyCart.View.CustomerLoginView;
import com.ecommerce.EasyCart.View.CustomerView;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Exception.BadRequestException;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import java.util.Optional;

public interface CustomerService {

	CustomerView add(CustomerForm form);
	
	CustomerView currentCustomer();
	Customer getCustomer();
	CustomerLoginView login(CustomerLoginForm form, Errors errors) throws BadRequestException;
	
	CustomerLoginView refresh(String refreshToken) throws BadRequestException;
	
	Collection<Customer> list();
	
	void delete(Integer customerId);
	
	CustomerView update(Integer customerId,CustomerForm form) throws NotFoundException;

}
