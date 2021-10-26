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

import com.ecommerce.EasyCart.Forms.SellerLoginForm;
import com.ecommerce.EasyCart.Service.SellerService;
import com.ecommerce.EasyCart.View.SellerLogin;
import com.ecommerce.EasyCart.View.SellerView;
/**
 *
 * @author anjana
 */
@RestController
@RequestMapping("/seller_login")
public class SellerLoginController {
     @Autowired
    private SellerService sellerService;
    
   @GetMapping
    public SellerView currentSeller() {
        return sellerService.currentSeller();
    }

    @PostMapping
    public SellerLogin login(@Valid @RequestBody SellerLoginForm form, Errors errors) {
        return sellerService.login(form, errors);
    }

    @PutMapping
    public SellerLogin refresh(@RequestBody String refreshToken) {
        return sellerService.refresh(refreshToken);
    }
}
