/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Repository;
import com.ecommerce.EasyCart.Entity.Order;
import com.ecommerce.EasyCart.Entity.Customer;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface OrderRepository extends JpaRepository<Order, Integer>  {
     List <Order> findAll();
}
