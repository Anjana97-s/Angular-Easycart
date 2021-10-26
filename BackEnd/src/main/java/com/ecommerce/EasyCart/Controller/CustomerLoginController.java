/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.Errors;

import com.ecommerce.EasyCart.Forms.CustomerLoginForm;
import com.ecommerce.EasyCart.Service.CustomerService;
import com.ecommerce.EasyCart.View.CustomerLoginView;
import com.ecommerce.EasyCart.View.CustomerView;

@RestController
@RequestMapping("/cust_login")
public class CustomerLoginController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public CustomerView currentCustomer() {
        return customerService.currentCustomer();
    }

    @PostMapping
    public CustomerLoginView login(@Valid @RequestBody CustomerLoginForm form, Errors errors) {
        return customerService.login(form, errors);
    }

    @PutMapping
    public CustomerLoginView refresh(@RequestBody String refreshToken) {
        return customerService.refresh(refreshToken);
    }


}
