/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.ServiceImpl;
import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import com.ecommerce.EasyCart.Forms.ProductForm;
import com.ecommerce.EasyCart.Repository.ProductRepository;
import com.ecommerce.EasyCart.Service.ProductService;
import com.ecommerce.EasyCart.View.ProductDetailView;
import com.ecommerce.EasyCart.View.ProductListView;
import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.EasyCart.Exception.ProductNotExistException;
import java.util.Optional;

/**
 *
 * @author anjana
 */
@Service
public class ProductServiceImpl implements ProductService{
    
     @Autowired
    private ProductRepository productRepository;

    


   /* @Override
    public Collection<ProductListView> list() {
                return productRepository.findAll();

    }*/
    @Override
    public Collection<Product> list() {
                return productRepository.findAll();

    }
    @Override
    public ProductDetailView add(ProductForm form) {
        return new ProductDetailView(productRepository.save(new Product(form)));

    }

    @Override
    public ProductDetailView get(Integer productId) throws NotFoundException {
     return productRepository.findByProductId(productId)
                .map((product) -> {
                    return new ProductDetailView(product);
                }).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public ProductDetailView update(Integer productId, ProductForm form) throws NotFoundException {
  return productRepository.findByProductId(productId)
                .map((product) -> {
                    return new ProductDetailView(productRepository.save(product.update(form)));
                }).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public void delete(Integer productId) {
        productRepository.delete(
                productRepository.findByProductId(productId)
                        .orElseThrow(NotFoundException::new)
        );
       }
@Override
    @Transactional
  public Product getProductById(Integer productId) throws ProductNotExistException {
        Optional<Product> optionalProduct = productRepository.findByProductId(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistException("Product id is invalid " + productId);
        return optionalProduct.get();
    }
@Override
 public  ProductListView getDtoFromProduct(Product product) {
        ProductListView productListView = new ProductListView(product);
        return productListView;
    }

  

  

   
    
}
