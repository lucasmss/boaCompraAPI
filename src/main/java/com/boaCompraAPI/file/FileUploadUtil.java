package com.boaCompraAPI.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.tomcat.jni.File;
import org.springframework.web.multipart.MultipartFile;
 
public class FileUploadUtil {
     
    public static void saveFile(String uploadDir, String productName,
            MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
         
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
        	Path filePath = Paths.get(uploadPath + multipartFile.getOriginalFilename());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + productName, ioe);
        }      
    }
}