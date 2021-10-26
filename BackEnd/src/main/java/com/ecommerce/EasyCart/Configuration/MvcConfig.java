/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Configuration;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import static org.springframework.web.servlet.mvc.method.RequestMappingInfo.paths;
/**
 *
 * @author anjana
 */
public class MvcConfig implements WebMvcConfigurer{
    
     public void addResourseHandlers(ResourceHandlerRegistry reg){
        exposeDirectory("productImages",reg);
    }
   
    public void  exposeDirectory(String dirName,ResourceHandlerRegistry reg){
        
        Path uploadDir=Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        if(dirName.startsWith("../"))
            dirName=dirName.replace("../", "");
        reg.addResourceHandler("/"+ dirName +"/**").addResourceLocations("file:/"+uploadPath +"/");
    }
}
