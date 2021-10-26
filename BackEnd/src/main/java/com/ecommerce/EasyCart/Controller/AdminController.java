/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.ecommerce.EasyCart.Entity.Admin;
import com.ecommerce.EasyCart.Forms.AdminForm;
import com.ecommerce.EasyCart.Service.AdminService;
import com.ecommerce.EasyCart.View.AdminView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ecommerce.EasyCart.Security.Util.FileUploadUtil;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/admin")
public class AdminController {
    
     @Autowired
    private AdminService adminService;
     @PostMapping
    public AdminView addProductProfileServer(@RequestParam("file") MultipartFile file, @RequestParam("admin") String admin) throws JsonMappingException, IOException {

        AdminForm form;
        form = new ObjectMapper().readValue(admin, AdminForm.class);
        form.setImage(file.getBytes());
        form.setFilename(file.getOriginalFilename());
        
     String filename =StringUtils.cleanPath(file.getOriginalFilename());
   
     AdminView p = adminService.add(form);
     String uploadDir="main/productImage/" + p.getAdminId();
     FileUploadUtil.saveFile(uploadDir,filename,file);
        return p;
    }
    @PutMapping("/image/{adminId}")
    public AdminView UpdateProfileServer(@RequestParam("file") MultipartFile file, @PathVariable("adminId") Integer adminId, @RequestParam("admin") String admin) throws JsonMappingException, IOException {

        AdminForm form;
        form = new ObjectMapper().readValue(admin, AdminForm.class);
        form.setImage(file.getBytes());
        form.setFilename(file.getOriginalFilename());
        
     String filename =StringUtils.cleanPath(file.getOriginalFilename());
   
     AdminView p = adminService.update(adminId,form);
     String uploadDir="main/productImage/" + p.getAdminId();
     FileUploadUtil.saveFile(uploadDir,filename,file);
        return p;
    }
   @GetMapping
  
    public AdminView AdminDetials(){
        return adminService.currentAdmin();
    }

 @PutMapping("/{adminId}")
    public AdminView update(
            @PathVariable("adminId") Integer adminId,
            @Valid @RequestBody AdminForm form)
     {
        return adminService.update(adminId, form);
    }
    

   
}
