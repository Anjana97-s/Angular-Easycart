/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Controller;

import com.ecommerce.EasyCart.Forms.ProductForm;
import com.ecommerce.EasyCart.Repository.ProductRepository;
import com.ecommerce.EasyCart.Service.ProductService;
import com.ecommerce.EasyCart.View.ProductDetailView;
import com.ecommerce.EasyCart.View.ProductListView;
import com.ecommerce.EasyCart.Entity.Product;
import java.security.Principal;
import java.util.Collection;
import java.util.ArrayList;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;

@RestController
@RequestMapping("/products")
public class ProductsController {
     @Autowired
    private ProductService productService;
     
   
 @Autowired
    ProductRepository productRepository;
    
     /* @GetMapping
    public Collection<ProductListView> list(Principal p) {
        return productService.list();
    }
     */
 @GetMapping
    public Collection<Product> list(Principal p) {
        return productService.list();
    }
    @PostMapping
    public ProductDetailView add( @Valid @RequestBody ProductForm form) {
        
        return productService.add(form);
    }
  
   
     @GetMapping("/{productId}")
    public ProductDetailView get(@PathVariable("productId") Integer productId) {
        return productService.get(productId);
    }
    @GetMapping("/view")
  public ResponseEntity<List<Product>> getAllProducts(@RequestParam("productId") Integer productId ) {
    try
    {
        List<Product> products = new ArrayList<Product>();
        

        productRepository.findById(productId).forEach(products::add);
        if (products.isEmpty() )
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
         return new ResponseEntity<>(products,HttpStatus.OK);
    }
    catch(Exception e)
    {
         return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @GetMapping("/products")
  public ResponseEntity<List<Product>> getAllTutorials(@RequestParam("fromdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromdate,@RequestParam("todate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date todate) {
    try
    {
        List<Product> products = new ArrayList<Product>();
        

        productRepository.findByCreateDateBetween(fromdate,todate).forEach(products::add);
        if (products.isEmpty() )
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
         return new ResponseEntity<>(products,HttpStatus.OK);
    }
    catch(Exception e)
    {
         return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
