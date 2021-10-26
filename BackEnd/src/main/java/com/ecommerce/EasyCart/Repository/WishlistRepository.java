/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Repository;
import com.ecommerce.EasyCart.Entity.Wishlist;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.EasyCart.Entity.Customer;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{
    
        List<Wishlist> findAllByCustomerCustomerIdOrderByCreateDateDesc(Integer customerId);
        List<Wishlist> deleteByCustomer(Customer customer);


}
