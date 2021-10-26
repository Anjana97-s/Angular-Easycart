/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Controller;

/**
 *
 * @author anjana
 */
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Forms.CustomerForm;
import com.ecommerce.EasyCart.Service.CustomerService;
import com.ecommerce.EasyCart.View.CustomerView;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerView add(@Valid @RequestBody CustomerForm form) {
        return customerService.add(form);
    }
    
    @GetMapping
    public Collection<Customer> list() {
        return customerService.list();
    }
    
    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable("customerId") Integer customerId) {
    	customerService.delete(customerId);
    }
    
    //update
    @PutMapping("/{customerId}")
    public CustomerView update(
            @PathVariable("customerId") Integer customerId,
            @Valid @RequestBody CustomerForm form) {
        return customerService.update(customerId, form);
    }
    

}
