package com.hit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hit.dao.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	void deleteById(Integer studentID);
	
	@Query(value = "SELECT * FROM students WHERE full_name = ?1", nativeQuery = true)
	Student findByName(String name);
	
	@Query(value = "SELECT * FROM students WHERE student_id = ?1", nativeQuery = true)
	Student findStudentByID(Integer studentID);
	
	@Query(value = "SELECT * FROM students WHERE phone = ?1", nativeQuery = true)
	Student findStudentByPhone(String phone);
}
