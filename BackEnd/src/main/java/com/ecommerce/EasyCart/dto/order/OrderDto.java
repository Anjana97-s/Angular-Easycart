/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.dto.order;
import javax.validation.constraints.NotNull;
import com.ecommerce.EasyCart.Entity.Order;

/**
 *
 * @author anjana
 */
public class OrderDto {
    private Integer orderId;
    private @NotNull Integer customerId;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.setOrderId(order.getOrderId());
        //this.setUserId(order.getUserId());
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
