package com.computershop.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computershop.dao.Category;
import com.computershop.dao.Product;
import com.computershop.dao.ProductImage;
import com.computershop.exceptions.NotFoundException;
import com.computershop.helpers.ConvertObject;
import com.computershop.repositories.CategoryRepository;
import com.computershop.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<?> GetAllCategories(@RequestParam(name = "page", required = false) Integer pageNum,
											  @RequestParam(name = "search", required = false) String search) {
		List<Category> categories = new ArrayList<>();
		
		if(pageNum!=null && search!=null) {
			Page <Category> page = categoryRepository.findAll(PageRequest.of(pageNum.intValue(), 10));
			if (page.getNumberOfElements() == 0) {
                return ResponseEntity.noContent().build();
            }
			List<Category> listAll = page.getContent();
			for(Category category : listAll) {
				if(category.getName().toLowerCase().contains(ConvertObject.fromSlugToString(search))) {
					categories.add(category);
				}
			}
			if(categories.size()==0)
				return ResponseEntity.noContent().build();
			return ResponseEntity.ok().body(categories);
		}
		
		if(search!=null) {
			categories = categoryRepository.findByNameContainingIgnoreCase(ConvertObject.fromSlugToString(search));
			if(categories.size()==0)
				return ResponseEntity.noContent().build();
			return ResponseEntity.ok().body(categories);
		}
		if(pageNum!=null) {
			Page <Category> page = categoryRepository.findAll(PageRequest.of(pageNum.intValue(), 10));
			if (page.getNumberOfElements() == 0) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok().body(page.getContent());
			
		}
		categories = categoryRepository.findAll();
		if (categories.size() == 0) {
            return ResponseEntity.noContent().build();
        }		
		return ResponseEntity.ok().body(categories);
	}
	
	
	/// chua xong
	@GetMapping("/{category}/products")
    public ResponseEntity<?> getProductsByCategory(@PathVariable("category") String name) {
       
		String categoryName = ConvertObject.fromSlugToString(name);
        List<Category> categories = categoryRepository.findByNameContainingIgnoreCase(categoryName);
        if (categories.size() == 0) {
            throw new NotFoundException("Not found category by : " + categoryName);
        }
        List<Product> products = new LinkedList<Product>();
        List<ProductImage> productImages = new LinkedList<ProductImage>();
        for(Category category : categories) {
        	for(Product product : category.getProducts()) {
        		products.add(product);
        		productImages.add(product.getProductImages().get(0));
        	}
        }
        for(Product product : products) {
        	for(ProductImage prdImg : product.getProductImages()) {
        		productImages.add(prdImg);
        	}
        }
        
       
        return ResponseEntity.ok().body("a");
    }

}
