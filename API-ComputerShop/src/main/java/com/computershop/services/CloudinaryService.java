package com.computershop.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.computershop.dao.Product;
import com.computershop.dao.ProductImage;
import com.computershop.repositories.ProductImageRepository;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private ProductImageRepository productImageRepository;

    public Map<?,?> uploadFile(MultipartFile file) {
        try {
            File uploadedFile = convertMultiPartToFile(file);
            Map<?, ?> uploadResult = cloudinary.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
//            return uploadResult.get("url").toString();
            return uploadResult;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductImage> uploadProductImage(MultipartFile[] files, Product product) throws IOException {
    	List<ProductImage> productImages = new ArrayList<>();
    	for (int i = 0; i < files.length; i++) {
    		Map<?, ?> uploadResult = uploadFile(files[i]);
            ProductImage productImage = new ProductImage();
            productImage.setProduct(product);
            productImage.setImageLink(uploadResult.get("url").toString());
            productImage.setPublicId(uploadResult.get("public_id").toString());
            ProductImage newProductImage = productImageRepository.save(productImage);
            productImages.add(newProductImage);
        }
    	return productImages;
    }
    
    public List<ProductImage> deleteProductImageByProduct(Product product) throws IOException {
    	List<ProductImage> productImages = product.getProductImages();
    	for (int i = 0; i < productImages.size(); i++) {
            ProductImage productImage = productImages.get(i);
            cloudinary.uploader().destroy(productImage.getPublicId(), ObjectUtils.emptyMap());
            productImageRepository.deleteByImageId(productImage.getImageId());
        }
    	return productImages;	
    }
    
    public File convertMultiPartToFile(MultipartFile file) throws IOException {
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