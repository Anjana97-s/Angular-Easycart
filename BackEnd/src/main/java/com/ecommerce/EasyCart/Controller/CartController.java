/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Controller;
import com.ecommerce.EasyCart.Service.CartService;
import com.ecommerce.EasyCart.Service.ProductService;
import com.ecommerce.EasyCart.Service.CustomerService;
import com.ecommerce.EasyCart.dto.cart.AddToCartDto;
import com.ecommerce.EasyCart.dto.cart.CartDto;
import com.ecommerce.EasyCart.dto.cart.CartItemDto;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Cart;
import com.ecommerce.EasyCart.Repository.CartRepository;

import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Exception.ProductNotExistException;
import com.ecommerce.EasyCart.Exception.AuthenticationFailException;
import com.ecommerce.EasyCart.Exception.CartItemNotExistException;
import com.ecommerce.EasyCart.Common.ApiResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

import javax.validation.Valid;
/**
 *
 * @author anjana
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;
 @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;
     @Autowired
    private CustomerService customerService;
     
    @PostMapping("/add/{productId}")
    public ResponseEntity<ApiResponse> addToCart(@PathVariable("productId") int ID ,@RequestBody AddToCartDto addToCartDto) throws AuthenticationFailException, ProductNotExistException {
                      Customer customer = customerService.getCustomer();

        Product product = productService.getProductById(ID);
        System.out.println("product to add"+  product.getPrdName());
        cartService.addToCart(addToCartDto, product,customer );
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems() throws AuthenticationFailException {
                            Customer customer = customerService.getCustomer();

        CartDto cartDto = cartService.listCartItems(customer);
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    } 
   @GetMapping("/get/{cartItemId}")
    public ResponseEntity<CartDto> getCartItems(@PathVariable("cartItemId") int itemID) throws AuthenticationFailException {
                           //   Customer customer = customerService.getCustomer();

        CartDto cartDto = cartService.listCartItems(itemID);
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    } 
    
 
     @PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody @Valid AddToCartDto cartDto) throws AuthenticationFailException,ProductNotExistException {
                              
        Customer customer = customerService.getCustomer();

        Product product = productService.getProductById(cartDto.getProductId());
        cartService.updateCartItem(cartDto, customer,product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID) throws AuthenticationFailException, CartItemNotExistException {
        int userId = customerService.getCustomer().getCustomerId();
        cartService.deleteCartItem(itemID, userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
   
}
