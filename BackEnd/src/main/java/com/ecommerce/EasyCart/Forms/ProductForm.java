/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author anjana
 */
public class ProductForm {
    
     @Size(max = 30)
    @NotBlank
    private String prdName;
    @Size(max = 100)
    private String prdDesc;
    private int price;
     @Size(max = 30)
    @NotBlank
    private String seller;
    private int stock;

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
    public Integer getStock()
{
     return stock;
}
  public void setStock(Integer stock )
  {
      this.stock=stock;
  }
}
