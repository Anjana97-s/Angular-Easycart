package com.ecommerce.EasyCart.Repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;
import com.ecommerce.EasyCart.Entity.Customer;


public interface CustomerRepository extends Repository<Customer, Integer>{
	
	Optional<Customer> findById(Integer customerId);
	
	Optional<Customer> findByCustomerIdAndPassword(Integer customerId, String password);
	
        Customer findByCustomerId(Integer customerId);
        
	Optional<Customer> findByEmail(String email);
	
	Customer save(Customer customer);
	
	Collection <Customer> findAll();
	
	void delete(Customer orElseThrow);

}
