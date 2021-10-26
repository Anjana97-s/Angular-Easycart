/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Repository;

import java.util.Collection;
import java.util.Optional;
import com.ecommerce.EasyCart.View.AdminView;

import org.springframework.data.repository.Repository;
import com.ecommerce.EasyCart.Entity.Admin;
import org.springframework.data.jpa.repository.Query;  
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author anjana
 */
public interface AdminRepository extends Repository<Admin, Integer> {
    
    Optional<Admin> findById(Integer adminId);
	
	Optional<Admin> findByAdminIdAndPassword(Integer adminId, String password);
	
        Admin findByAdminId(Integer adminId);
        
	Optional<Admin> findByEmail(String email);
	
	Admin save(Admin admin);
	
	Collection <Admin> findAll();
	
	void delete(Admin orElseThrow);
     /*   @Modifying
@Query("update Admin u set u.image = :image And u.filename=:filename where u.admin_id = :adminId")
AdminView updateImage(@Param(value = "adminId") Integer  adminId, @Param(value = "image") byte[] image,@Param(value = "fname") String filename);
*/
}
