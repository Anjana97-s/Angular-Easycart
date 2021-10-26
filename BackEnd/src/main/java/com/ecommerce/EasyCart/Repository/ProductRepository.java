/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Repository;

import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.View.ProductDetailView;
import com.ecommerce.EasyCart.View.ProductListView;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.repository.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;

/**
 *
 * @author anjana
 */
public interface ProductRepository extends Repository<Product, Integer> {
    
    //Collection<ProductListView> findAll();
    
    Optional<Product> findByProductId(Integer productId);
    
   // Optional<Product> findById(Integer productId );
    Product save(Product product);
   List <Product> findById( Integer productId );
 

     void delete(Product product);
     @Query(value = "SELECT * FROM PRODUCT ", nativeQuery = true)
   Collection<Product> findAll();
List <Product> findByCreateDateBetween(   Date fromdate,  Date todate);


   
    
     
}
