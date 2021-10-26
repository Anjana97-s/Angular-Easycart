/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.ServiceImpl;
import com.ecommerce.EasyCart.dto.cart.AddToCartDto;
import com.ecommerce.EasyCart.dto.cart.CartDto;
import com.ecommerce.EasyCart.dto.cart.CartItemDto;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Entity.Cart;
import com.ecommerce.EasyCart.Repository.CartRepository;
import com.ecommerce.EasyCart.Service.CartService;
 import com.ecommerce.EasyCart.Exception.CartItemNotExistException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author anjana
 */
@Service

public class CartServiceImpl implements CartService{
     @Autowired
    private  CartRepository cartRepository;
     
   
     @Override
     @Transactional
     public void addToCart(AddToCartDto addToCartDto, Product product,Customer customer)
     {
           Cart cart = new Cart(product, addToCartDto.getQuantity(), customer);
        cartRepository.save(cart);
     }
      @Override
     @Transactional
       public CartDto listCartItems(Customer customer)
       {
        List<Cart> cartList = cartRepository.findAllByCustomerOrderByCreateDateDesc(customer);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems){
            totalCost += (cartItemDto.getProduct().getPrice()* cartItemDto.getQuantity());
        }
        CartDto cartDto = new CartDto(cartItems,totalCost);
        return cartDto;
       }
          @Transactional

      public  CartItemDto getDtoFromCart(Cart cart)
       {
           CartItemDto cartItemDto = new CartItemDto(cart);
        return cartItemDto; 
       }
        @Override
     @Transactional
         public void updateCartItem(AddToCartDto cartDto, Customer customer,Product product)
         {
             Cart cart = cartRepository.getOne(cartDto.getId());
        cart.setQuantity(cartDto.getQuantity());
        cart.setCreateDate(new Date());
        cartRepository.save(cart);
         }
         @Override
     @Transactional
           public void deleteCartItem(int id,int customerId) throws CartItemNotExistException
           {
                if (!cartRepository.existsById(id))
            throw new CartItemNotExistException("Cart id is invalid : " + id);
        cartRepository.deleteById(id);
           }
     @Override
     @Transactional
          public void deleteCartItems(int customerId)
          {
           cartRepository.deleteAll();

          }
          @Override
     @Transactional
           public void deleteCustomerCartItems(Customer customer){
                       cartRepository.deleteByCustomer(customer);

           }
            @Override
     @Transactional
       public CartDto listCartItems(int id)
       {
        List<Cart> cartList = cartRepository.findProductById(id);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
       
        CartDto cartDto = new CartDto(cartItems);
        return cartDto;
       }
          
}
