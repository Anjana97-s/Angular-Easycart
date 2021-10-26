/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.ecommerce.EasyCart.Service.WishlistService;
import com.ecommerce.EasyCart.Entity.Wishlist;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Repository.WishlistRepository;
import com.ecommerce.EasyCart.Service.ProductService;
import com.ecommerce.EasyCart.View.ProductListView;
import com.ecommerce.EasyCart.View.WishListView;

import com.ecommerce.EasyCart.Service.CustomerService;
import com.ecommerce.EasyCart.Common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ecommerce.EasyCart.Forms.ProductForm;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.EasyCart.View.CustomerView;
import com.ecommerce.EasyCart.Exception.ProductNotExistException;
import com.ecommerce.EasyCart.Exception.AuthenticationFailException;
import com.ecommerce.EasyCart.Exception.CartItemNotExistException;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    
    @Autowired
    private WishlistService wishlistService;
     @Autowired
    private ProductService productService;
    @Autowired
    private WishlistRepository wishlistRepository;
     @Autowired
    private CustomerService customerService;
    /* @GetMapping("/ad")
        public ResponseEntity<List<ProductListView>> getWishList() {
                int user_id = customerService.getCustomer().getCustomerId();
                List<Wishlist> body = wishlistService.readWishList(user_id);
                List<ProductListView> products = new ArrayList<ProductListView>();
                for (Wishlist wishlist : body) {
                        products.add(productService.getDtoFromProduct(wishlist.getProduct()));
                }

                return new ResponseEntity<List<ProductListView>>(products, HttpStatus.OK);
        }*/
         @GetMapping("/")
        public ResponseEntity<List<WishListView>> getWishList() {
                int user_id = customerService.getCustomer().getCustomerId();
                List<Wishlist> body = wishlistService.readWishList(user_id);
                List<WishListView> products = new ArrayList<WishListView>();
                for (Wishlist wishlist : body) {
                        products.add(wishlistService.getDtoFromProduct(wishlist.getId(),wishlist.getProduct()));
                }

                return new ResponseEntity<List<WishListView>>(products, HttpStatus.OK);
        }
    @PostMapping("/add")
        public ResponseEntity<ApiResponse> addWishList(@RequestBody Product product) {
               Customer customer = customerService.getCustomer();
                Wishlist wishlist = new Wishlist(customer, product);
                wishlistService.createWishlist(wishlist);
                return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Add to wishlist"), HttpStatus.CREATED);

        }
         @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID) throws AuthenticationFailException, CartItemNotExistException {
        int userId = customerService.getCustomer().getCustomerId();
        wishlistService.deleteWishlistItem(itemID, userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
    
}
