/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Controller;
import com.ecommerce.EasyCart.dto.cart.AddToCartDto;
import com.ecommerce.EasyCart.dto.cart.CartDto;
import com.ecommerce.EasyCart.dto.cart.CartItemDto;
import com.ecommerce.EasyCart.dto.order.OrderDto;
import com.ecommerce.EasyCart.dto.order.PlaceOrderDto;
import com.ecommerce.EasyCart.Service.OrderItemService;
import com.ecommerce.EasyCart.Service.OrderService;
import com.ecommerce.EasyCart.Service.CustomerService;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Entity.Cart;
import com.ecommerce.EasyCart.Entity.Order;
import com.ecommerce.EasyCart.Entity.OrderItem;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController {
     @Autowired
    private OrderService orderService;
    
    
    @Autowired
    private OrderItemService orderItemService;

    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/all")
    public List<Order> AllOrders() {
        
      
        List<Order> orderDtoList = orderService.list();
        return orderDtoList;
    }
    @PostMapping("/add")
    public Order placeOrder( PlaceOrderDto placeOrderDto)
             {
        Customer customer=customerService.currentCustomer();
        Order order = orderService.placeOrder(placeOrderDto,customer);
        return order;
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }
     @GetMapping
    public List<Order> getAllOrders()  {
        
       Customer customer=customerService.currentCustomer();
        List<Order> orderDtoList = orderService.listOrders(customer);
        return orderDtoList;
//        return new ResponseEntity<List<Order>>(orderDtoList,HttpStatus.OK);
    }

    
    
}
