/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Service;
import java.util.Collection;

import org.springframework.validation.Errors;
import com.ecommerce.EasyCart.Forms.SellerForm;
import com.ecommerce.EasyCart.Forms.SellerLoginForm;
import com.ecommerce.EasyCart.View.SellerLogin;

import com.ecommerce.EasyCart.View.SellerView;
import com.ecommerce.EasyCart.Entity.Seller;
import com.ecommerce.EasyCart.Exception.BadRequestException;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import java.util.Optional;
/**
 *
 * @author anjana
 */
public interface SellerService {
    
   // SellerView add(SellerForm form);
    	Collection<Seller> list();
         SellerView add(SellerForm form);
	Seller getSeller();

    SellerView currentSeller();

    SellerLogin login(SellerLoginForm form, Errors errors) throws BadRequestException;

    SellerLogin refresh(String refreshToken) throws BadRequestException;

void delete(Integer sellerId);
	
SellerView update(Integer sellerId,SellerForm form) throws NotFoundException;

}
