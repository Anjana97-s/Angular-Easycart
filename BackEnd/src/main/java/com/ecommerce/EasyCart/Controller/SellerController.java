/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Controller;

import java.util.Collection;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ecommerce.EasyCart.Security.Util.FileUploadUtil;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import javax.servlet.http.HttpServletResponse;
import com.ecommerce.EasyCart.Entity.Seller;
import com.ecommerce.EasyCart.Forms.SellerForm;
import com.ecommerce.EasyCart.Service.SellerService;
import com.ecommerce.EasyCart.View.SellerView;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    

     @PostMapping
    public SellerView addProductProfileServer(@RequestParam("file") MultipartFile file, @RequestParam("seller") String seller) throws JsonMappingException, IOException {

        SellerForm form;
        form = new ObjectMapper().readValue(seller, SellerForm.class);
        form.setImage(file.getBytes());
        form.setFilename(file.getOriginalFilename());
        
     String filename =StringUtils.cleanPath(file.getOriginalFilename());
   
     SellerView p = sellerService.add(form);
     String uploadDir="main/sellerImage/" + p.getSellerId();
     FileUploadUtil.saveFile(uploadDir,filename,file);
        return p;
    }
   @GetMapping
  
    public SellerView SellerDetials(){
        return sellerService.currentSeller();
    }
@GetMapping("/seller")
 public Collection<Seller> list() {
        return sellerService.list();
    }
  @PutMapping("/image/{sellerId}")
  public SellerView updateProfileServer(@RequestParam("file") MultipartFile file,@PathVariable("sellerId") Integer sellerId, @RequestParam("seller") String seller) throws JsonMappingException, IOException {

        SellerForm form;
        form = new ObjectMapper().readValue(seller, SellerForm.class);
        form.setImage(file.getBytes());
        form.setFilename(file.getOriginalFilename());
        
     String filename =StringUtils.cleanPath(file.getOriginalFilename());
   
     SellerView p = sellerService.update(sellerId,form);
     String uploadDir="main/sellerImage/" + p.getSellerId();
     FileUploadUtil.saveFile(uploadDir,filename,file);
        return p;
    }
  
    @PutMapping("/{sellerId}")
    public SellerView update(
            @PathVariable("sellerId") Integer sellerId,
            @Valid @RequestBody SellerForm form)
     {
        return sellerService.update(sellerId, form);
    }

}
