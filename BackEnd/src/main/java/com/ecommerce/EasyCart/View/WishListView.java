/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.View;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Entity.Wishlist;
/**
 *
 * @author anjana
 */
public class WishListView {
    private final int id;
    private final Product product;
    
    public int getId()
    {
        return id;
    }
    public Product getProduct()
    {
        return product;
    }
    public WishListView(int id,Product product)
    {
        this.id=id;
        this.product=product;
    }
    public WishListView(Wishlist s)
    {
        this.id=s.getId();
        this.product=s.getProduct();
    }
}
