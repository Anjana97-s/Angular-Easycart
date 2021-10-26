/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Security.Util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author anjana
 */
public class FileUploadUtil {
 
        public static void saveFile(String uploadDir,String filename,MultipartFile file) throws IOException{
        Path uploadPath = Paths.get(uploadDir);
        
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }try(InputStream inputStream = file.getInputStream()){
            Path filePath = uploadPath.resolve(filename);
            Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
            
        }catch(IOException e){
            throw new IOException("could not save image file: "+filename,e);
        }
    }
}
