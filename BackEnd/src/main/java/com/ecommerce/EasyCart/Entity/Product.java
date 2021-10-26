/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Entity;

import com.ecommerce.EasyCart.Forms.ProductForm;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author anjana
 */
@Entity
@Table(name = "product")
public class Product {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String prdName;
    private String prdDesc;
    private String seller;
    private Integer price;
    private Integer stock;
    private Integer status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
   // @ManyToOne(optional = false, fetch = FetchType.LAZY)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

   // private Customer customer;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Wishlist> wishlistList;
     @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts;
    public Product() {
         
    }
     public Product(Integer productId) {
         this.productId=productId;
    } 
      public Product(ProductForm form) {
          //this.customer=new Customer(customerId);
          this.prdName=form.getPrdName();
           this.prdDesc=form.getPrdDesc();
           this.seller=form.getSeller();
           this.price=form.getPrice();
           this.stock=form.getStock();
           Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
      }
     
        public Product update(ProductForm form) {
       
 this.prdName=form.getPrdName();
           this.prdDesc=form.getPrdDesc();
           this.seller=form.getSeller();
           this.price=form.getPrice();
        Date dt = new Date();
        this.updateDate = dt;

        return this;
    }
      
     public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public String getPrdName() {
        return prdName;
    }

    public void setName(String prdName ) {
        this.prdName = prdName;
    }
     public String getPrdDesc() {
        return prdDesc;
    }

    public void setPrdDesc(String prdDesc ) {
        this.prdDesc = prdDesc;
    }
     public String getSeller() {
        return seller;
    }

    public void setSeller(String seller  ) {
        this.seller = seller;
    }
    public Integer getPrice()
    {
        return price;
    }
    public void setPrice(Integer price)
    {
        this.price=price;
    }
    
 public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
public Integer getStock()
{
     return stock;
}
  public void setStock(Integer stock )
  {
      this.stock=stock;
  }


   
    
}
