package com.computershop.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    public String uploadFile(MultipartFile file) {
        try {
            File uploadedFile = convertMultiPartToFile(file);
            Map<?, ?> uploadResult = cloudinary.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
            return  uploadResult.get("url").toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    
    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    
    
	public ResponseEntity<?> deleteFile(String publicId) {
    	 try {
    		 cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
             return  ResponseEntity.status(200).build();
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }
}