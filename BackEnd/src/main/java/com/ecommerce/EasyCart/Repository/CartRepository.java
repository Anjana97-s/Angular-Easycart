/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Repository;
import com.ecommerce.EasyCart.Entity.Wishlist;
import com.ecommerce.EasyCart.Entity.Cart;
import com.ecommerce.EasyCart.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import java.util.List;
@Repository

public interface CartRepository  extends JpaRepository<Cart, Integer>  {
    
     List<Cart> findAllByCustomerOrderByCreateDateDesc(Customer customer);

    List<Cart> deleteByCustomer(Customer customer);
    List<Cart> findProductById(int id);


}
