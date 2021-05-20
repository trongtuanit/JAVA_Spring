package com.computershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

}
