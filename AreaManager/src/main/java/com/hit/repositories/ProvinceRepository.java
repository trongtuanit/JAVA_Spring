package com.hit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hit.dao.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {
	@Query(value = "SELECT * FROM provinces WHERE province_code = ?1", nativeQuery = true)
	Province findByCode(String code);
}
