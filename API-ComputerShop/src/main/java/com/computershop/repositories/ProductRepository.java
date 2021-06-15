package com.computershop.repositories;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.computershop.dao.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByNameContainingIgnoreCase(String name);
	
	List<Product> findByNameContaining(String name);
	
	List<Product> findByName(String name);
	
	List<Product> findAllByQuantitySoldByDesc();
	
//	Optional<Product> findById(Long id);

}
