/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ecommerce.EasyCart.dto.cart.AddToCartDto;
import com.ecommerce.EasyCart.dto.cart.CartDto;
import com.ecommerce.EasyCart.dto.cart.CartItemDto;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Entity.Cart;
 import com.ecommerce.EasyCart.Exception.CartItemNotExistException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author anjana
 */

public interface CartService {
    
   
     public void addToCart(AddToCartDto addToCartDto, Product product,Customer customer);
      public CartDto listCartItems(Customer customer) ;
        public  CartItemDto getDtoFromCart(Cart cart);
        public void updateCartItem(AddToCartDto cartDto, Customer customer,Product product);
         public void deleteCartItem(int id,int customerId) throws CartItemNotExistException;
         public void deleteCartItems(int customerId);
         public void deleteCustomerCartItems(Customer customer);
         public CartDto listCartItems(int id);
          
}
