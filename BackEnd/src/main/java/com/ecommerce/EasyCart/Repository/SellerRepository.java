/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Repository;
import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;
import com.ecommerce.EasyCart.Entity.Seller;
/**
 *
 * @author anjana
 */
public interface SellerRepository extends Repository<Seller, Integer> {
    
    Optional<Seller> findById(Integer sellerId);
	
		Optional<Seller> findBySellerIdAndPassword(Integer sellerId, String password);

        Seller findBySellerId(Integer sellerId);
        
	Optional<Seller> findByEmail(String email);
	
	Seller save(Seller seller);
	
	Collection <Seller> findAll();
	
	void delete(Seller orElseThrow);
}
