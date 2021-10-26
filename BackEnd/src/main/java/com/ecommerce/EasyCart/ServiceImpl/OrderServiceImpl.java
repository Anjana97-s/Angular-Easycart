/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.ServiceImpl;
import com.ecommerce.EasyCart.dto.cart.AddToCartDto;
import com.ecommerce.EasyCart.dto.cart.CartDto;
import com.ecommerce.EasyCart.dto.cart.CartItemDto;
import com.ecommerce.EasyCart.dto.order.OrderDto;
import com.ecommerce.EasyCart.dto.order.PlaceOrderDto;
import com.ecommerce.EasyCart.Service.OrderItemService;
import com.ecommerce.EasyCart.Service.OrderService;
import com.ecommerce.EasyCart.Service.CustomerService;
import com.ecommerce.EasyCart.Service.CartService;

import com.ecommerce.EasyCart.Repository.OrderRepository;
import com.ecommerce.EasyCart.Repository.OrderItemsRepository;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Entity.Cart;
import com.ecommerce.EasyCart.Entity.Order;
import com.ecommerce.EasyCart.Entity.OrderItem;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Collection;

@Service

public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    private CustomerService customerService;
    
    @Override
    @Transactional
    public Order saveOrder(PlaceOrderDto orderDto,  Customer customer) {
        Order order = getOrderFromDto(orderDto,  customerService.currentCustomer());

        return orderRepository.save(order);
    }
     @Transactional
    public Order getOrderFromDto(PlaceOrderDto orderDto, Customer customer) {
        Order order = new Order(orderDto,  customerService.currentCustomer());
        return order;
    }

    @Override
    @Transactional
    public List<Order> listOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }

    @Override
    @Transactional
    public Order getOrder(int orderId)  {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            return order.get();
        }
    }
     @Override
    @Transactional
//    public void placeOrder(Customer customer) {
    public Order placeOrder( PlaceOrderDto placeOrderDto , Customer customer) {
        CartDto cartDto = cartService.listCartItems(customerService.currentCustomer());

//        PlaceOrderDto placeOrderDto = new PlaceOrderDto();
        placeOrderDto.setCustomer(customerService.currentCustomer());
//        placeOrderDto.setTotalPrice(cartDto.getTotalCost());
      
       
       
        

        Order newOrder = saveOrder(placeOrderDto, customer);
        List<CartItemDto> cartItemDtoList = cartDto.getcartItems();
        for (CartItemDto cartItemDto : cartItemDtoList) {
//            cartItemDtoList.stream().map(cartItemDto -> new OrderItem(
            OrderItem orderItem = new OrderItem(
                    newOrder,
                    cartItemDto.getProduct(),
                    cartItemDto.getQuantity(),
                    cartItemDto.getProduct());
            orderItemService.addOrderedProducts(orderItem);
        }
        cartService.deleteCustomerCartItems(customerService.currentCustomer());
        return newOrder;
    }
    /* @Override
    public  <Order> list() {
                return orderRepository.findAll();

    }
    */
    @Override
    public List<Order> list() {
          List<Order> orderList = orderRepository.findAll();
        return orderList;
      
    }
    
}
