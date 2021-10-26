/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Service;
import com.ecommerce.EasyCart.Entity.Wishlist;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.View.WishListView;
import com.ecommerce.EasyCart.Exception.CartItemNotExistException;

import java.util.List;


public interface WishlistService {
    
     void createWishlist(Wishlist wishlist);
     public List<Wishlist> readWishList(Integer customerId);
     public void deleteWishlistItem(int id,int customerId)throws CartItemNotExistException;
         public void deleteWishlistItems(int customerId);
         public void deleteCustomerWishlistItems(Customer customer);
         public  WishListView getDtoFromProduct(int id,Product product);

}
