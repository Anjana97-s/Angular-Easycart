/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Service;

import com.ecommerce.EasyCart.Exception.NotFoundException;
import com.ecommerce.EasyCart.Forms.ProductForm;
import com.ecommerce.EasyCart.View.ProductDetailView;
import com.ecommerce.EasyCart.View.ProductListView;
import java.util.Collection;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Exception.ProductNotExistException;

public interface ProductService {
    
     //Collection<ProductListView> list();
    Collection<Product> list();
     ProductDetailView add(ProductForm form);

     ProductDetailView get(Integer productId) throws NotFoundException;

     ProductDetailView update(Integer productId, ProductForm form)throws NotFoundException;

     void delete(Integer productId);
public Product getProductById(Integer productId)throws ProductNotExistException ;
public  ProductListView getDtoFromProduct(Product product);
  //  public ProductDetailView insert(ProductForm form, Integer productId)throws NotFoundException;
    
}
