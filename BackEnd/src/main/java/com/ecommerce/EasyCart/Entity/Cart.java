/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ecommerce.EasyCart.dto.cart.AddToCartDto;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
       import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="cart")
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "create_date")
    private Date createDate;
    
     @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
      @OneToOne(targetEntity =  Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "customer_id")
    private Customer customer;
    private int quantity;
    
     public Cart(Customer customer) {
        this.customer  = customer;
    }
   public Cart() {
    }
public Cart(Product product, int quantity, Customer customer){
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.createDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
public Customer  getCustomer() {
        return  customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
}
