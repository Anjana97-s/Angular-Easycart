/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Service;
import com.ecommerce.EasyCart.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ecommerce.EasyCart.dto.cart.AddToCartDto;
import com.ecommerce.EasyCart.dto.cart.CartDto;
import com.ecommerce.EasyCart.dto.cart.CartItemDto;
import com.ecommerce.EasyCart.dto.order.OrderDto;
import com.ecommerce.EasyCart.dto.order.PlaceOrderDto;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Entity.Cart;
import com.ecommerce.EasyCart.Entity.Order;
import com.ecommerce.EasyCart.Entity.OrderItem;

import com.ecommerce.EasyCart.Exception.CartItemNotExistException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public interface OrderItemService {
    void addOrderedProducts(OrderItem orderItem);
}
