/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "wishlist")
public class Wishlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToOne(targetEntity =  Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "customer_id")
    private Customer customer;
    
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    public Date getCreateDate() {
        return createDate;
    }
 public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Wishlist() {
    }


    public Wishlist( Customer customer,Product product) {
        this.customer =customer;
        this.product = product;
        Date dt = new Date();
        this.createDate = dt;
    }
    public Wishlist(Product product ,Integer id)
    {
        this.product=product;
        this.id=id;
    }

}
