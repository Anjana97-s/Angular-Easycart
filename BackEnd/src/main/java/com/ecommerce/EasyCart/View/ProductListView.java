/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.View;

import com.ecommerce.EasyCart.Json.Json;
import java.util.Date;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Wishlist;

/**
 *
 * @author anjana
 */
public class ProductListView {
    private  int productId;
    private  String prdName;
    private  String prdDesc;
    private  String seller;
    private  int price;
  
     public ProductListView (Product product) {
           this.setProductId(product.getProductId());
        this.setPrdName(product.getPrdName());
        this.setPrdDesc(product. getPrdDesc());
        this.setSeller(product.getSeller());
        this.setPrice(product.getPrice());
     }
     public ProductListView( int productId,String prdName,String prdDesc ,String seller,int price)
    {
        this.productId=productId;
        this.prdName=prdName;
        this.prdDesc=prdDesc;
        this.price=price;
        this.seller=seller;
      
        
    }
          public Integer getProductId() {
        return productId;
    }
 public String getPrdName() {
        return prdName;
    }
  public String getPrdDesc() {
        return prdDesc;
    }
   public String getSeller() {
        return seller;
    }
   public Integer getPrice()
    {
        return price;
    }
   
     public void setProductId(Integer productId) {
        this.productId = productId;
    }
    

   
      public void setPrdName(String prdName ) {
        this.prdName = prdName;
    }
      public void setPrdDesc(String prdDesc ) {
        this.prdDesc = prdDesc;
    }
        public void setSeller(String seller  ) {
        this.seller = seller;
    }
        public void setPrice(Integer price)
    {
        this.price=price;
    }
}
