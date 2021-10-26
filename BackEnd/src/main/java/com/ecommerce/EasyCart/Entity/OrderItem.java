/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
/**
 *
 * @author anjana
 */
@Entity

public class OrderItem {
    
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private @NotNull int quantity;

    private @NotNull double price;


    private Date createdDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    public OrderItem(){}

    public OrderItem(Order order, @NotNull Product product, @NotNull int quantity, @NotNull double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.order= order;
        this.createdDate = new Date();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
