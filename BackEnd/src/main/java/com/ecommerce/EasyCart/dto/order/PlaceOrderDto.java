/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.dto.order;
import javax.validation.constraints.NotNull;
import com.ecommerce.EasyCart.Entity.Cart;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Customer;
/**
 *
 * @author anjana
 */
public class PlaceOrderDto {
     private @NotNull double price;
    private @NotNull int quantity;
    private @NotNull int orderId;
    private @NotNull int productId;
    public PlaceOrderDto () {}

    public PlaceOrderDto(@NotNull double price, @NotNull int quantity, @NotNull int orderId, @NotNull int productId) {
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
