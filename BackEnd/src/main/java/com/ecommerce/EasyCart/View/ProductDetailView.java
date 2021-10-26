/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.View;

import com.ecommerce.EasyCart.Entity.Product;
import java.util.Date;

/**
 *
 * @author anjana
 */
public class ProductDetailView  extends ProductListView {
    
    public ProductDetailView(Product product) {
        super(
        product.getProductId(),
                product.getPrdName(),
                product.getPrdDesc(),
                product.getSeller(),
                product.getPrice()

               
               
              
             
        );
    }
    

    
    
}
