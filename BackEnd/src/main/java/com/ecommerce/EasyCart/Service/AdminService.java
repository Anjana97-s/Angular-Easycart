/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Service;
import java.util.Collection;

import org.springframework.validation.Errors;

import com.ecommerce.EasyCart.Forms.AdminForm;
import com.ecommerce.EasyCart.Forms.AdminLoginForm;
import com.ecommerce.EasyCart.View.AdminLoginView;
import com.ecommerce.EasyCart.View.AdminView;
import com.ecommerce.EasyCart.Entity.Admin;
import com.ecommerce.EasyCart.Exception.BadRequestException;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.util.Optional;
/**
 *
 * @author anjana
 */
public interface AdminService {
    
     AdminView add(AdminForm form);
      Collection<Admin> list();
	Admin getAdmin();

    AdminView currentAdmin();

    AdminLoginView login(AdminLoginForm form, Errors errors) throws BadRequestException;

    AdminLoginView refresh(String refreshToken) throws BadRequestException;

void delete(Integer adminId);
	
AdminView update(Integer adminId,AdminForm form) throws NotFoundException;
}
