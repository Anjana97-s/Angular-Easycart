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

import com.ecommerce.EasyCart.Forms.AdminLoginForm;
import com.ecommerce.EasyCart.Service.AdminService;
import com.ecommerce.EasyCart.View.AdminLoginView;
import com.ecommerce.EasyCart.View.AdminView;

@RestController
@RequestMapping("/admin_login")
public class AdminLoginController {
    
    @Autowired
    private AdminService adminService;
    
   @GetMapping
    public AdminView currentAdmin() {
        return adminService.currentAdmin();
    }

    @PostMapping
    public AdminLoginView login(@Valid @RequestBody AdminLoginForm form, Errors errors) {
        return adminService.login(form, errors);
    }

    @PutMapping
    public AdminLoginView refresh(@RequestBody String refreshToken) {
        return adminService.refresh(refreshToken);
    }
}
