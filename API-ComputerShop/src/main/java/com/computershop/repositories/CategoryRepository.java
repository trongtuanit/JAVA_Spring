package com.computershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.computershop.dao.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
