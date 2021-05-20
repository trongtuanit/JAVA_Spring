package com.hit.repositories;


import org.springframework.stereotype.Repository;

import com.hit.dao.District;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
	@Query(value = "SELECT * FROM districts WHERE district_code = ?1", nativeQuery = true)
	District findByCode(String code);
	
}
