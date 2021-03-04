package com.hit.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.hit.dao.Student;
import com.hit.dao.Subject;
import com.hit.dto.StudentDTO;
import com.hit.repositories.StudentRepository;
import com.hit.repositories.SubjectRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SubjectRepository SubjectRepository;

	
	@GetMapping
	public ResponseEntity<?> getAllStudent(@RequestParam(value="page", required = false) Integer page) {
		if(page!=null) {
			Page<Student> listStudentOfPage = studentRepository.findAll(PageRequest.of(page.intValue(), 7));
			List<Student> listStudent = listStudentOfPage.getContent();
			ResponseEntity.status(200).body(listStudent);
		}

		List <Student> list = studentRepository.findAll();
		if(list.size()==0)
			return ResponseEntity.status(204).build();
		return ResponseEntity.status(200).body(list);
	}
	

	@PostMapping
	public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
		List <Subject> listSubject =  SubjectRepository.findAllById(studentDTO.getListSubjectId());
		
		Student newStudent = new Student(
					null, 
					studentDTO.getFullName(), 
					studentDTO.getPhone(), 
					listSubject,
					null,null
				);
		

		studentRepository.save(newStudent);
		return ResponseEntity.status(201).body(newStudent);
	}
	
	//GET STUDENT BY ID
	
	@GetMapping("/{studentID}")
	public ResponseEntity<?> getStudentById(@PathVariable("studentID") Integer studentID) {
		Optional<Student> student = studentRepository.findById(studentID);
		return ResponseEntity.status(200).body(student.get());
	}
	
	
	
	@PatchMapping("/{studentID}")
	public ResponseEntity<?> editStudentById
		(
			@PathVariable("studentID") Integer studentID,
			@RequestBody StudentDTO studentDTO
		) 
	{
		Optional<Student> optional = studentRepository.findById(studentID);
		if(optional.get()==null)
			return ResponseEntity.status(409).build();
		
		// check if phone is registered by another student 
		if(studentRepository.findStudentByPhone(studentDTO.getPhone()).getId().intValue() != studentID.intValue()) 
			return ResponseEntity.status(409).build();
		

		
		Student student = optional.get();
		List <Subject>listSubject =SubjectRepository.findAllById(studentDTO.getListSubjectId());
		
		student.setFullName(studentDTO.getFullName());
		student.setListSubjects(listSubject);
		student.setPhone(studentDTO.getPhone());
		Student newStudent = studentRepository.save(student);
		return ResponseEntity.status(200).body(newStudent);
	}
	


	@DeleteMapping("/{studentID}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("studentID") Integer studentID) {	
		if(studentRepository.findStudentByID(studentID)==null)
			return ResponseEntity.status(409).build();
		studentRepository.deleteById(studentID);
		return ResponseEntity.status(200).build();
	}
	
	
}
