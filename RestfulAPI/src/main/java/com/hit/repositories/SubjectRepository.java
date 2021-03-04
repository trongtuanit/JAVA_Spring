package com.hit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.hit.dao.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
	@Query(value = "SELECT * FROM subjects WHERE name = ?1", nativeQuery = true)
	Subject findByName(String name);
	
	void deleteById(Integer subjectID);
}
