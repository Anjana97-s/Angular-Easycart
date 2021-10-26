/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.ServiceImpl;
import com.ecommerce.EasyCart.Entity.Wishlist;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.View.WishListView;

import com.ecommerce.EasyCart.Exception.CartItemNotExistException;

import com.ecommerce.EasyCart.Repository.WishlistRepository;
import com.ecommerce.EasyCart.Service.WishlistService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ecommerce.EasyCart.Security.Util.SecurityUtil;
import com.ecommerce.EasyCart.View.WishListView;


@Service
public class WishlistServiceImpl implements WishlistService{
    
    
     @Autowired
    private WishlistRepository wishlistRepository;
     @Override
     @Transactional

public void createWishlist(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }
     @Override
     @Transactional
 public List<Wishlist> readWishList(Integer customerId) {
        return wishlistRepository.findAllByCustomerCustomerIdOrderByCreateDateDesc(customerId);
    }
  @Override
     @Transactional
           public void deleteWishlistItem(int id,int customerId) throws CartItemNotExistException
           {
                if (!wishlistRepository.existsById(id))
            throw new CartItemNotExistException("Wishlist id is invalid : " + id);
        wishlistRepository.deleteById(id);
           }
     @Override
     @Transactional
          public void deleteWishlistItems(int customerId)
          {
           wishlistRepository.deleteAll();

          } 
           @Override
     @Transactional
           public void deleteCustomerWishlistItems(Customer customer){
                       wishlistRepository.deleteByCustomer(customer);

           }
           @Override
 public  WishListView getDtoFromProduct(int id,Product product) {
        WishListView wishlistView = new WishListView(id,product);
        return wishlistView;
    }
}
