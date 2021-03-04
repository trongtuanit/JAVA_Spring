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
//import com.hit.dao.Student;
//import com.hit.dao.Student;
import com.hit.dao.Subject;

import com.hit.dto.SubjectDTO;
import com.hit.repositories.StudentRepository;
//import com.hit.repositories.StudentRepository;
//import com.hit.repositories.StudentRepository;
import com.hit.repositories.SubjectRepository;


@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping
	public ResponseEntity<?> getAllSubject(@RequestParam(value="page", required = false) Integer page) {
		if(page!=null) {
			Page<Subject> listSubjectOfPage = subjectRepository.findAll(PageRequest.of(page.intValue(), 7));
			List<Subject> listSubject = listSubjectOfPage.getContent();
			ResponseEntity.status(200).body(listSubject);
		}
		List <Subject> list = subjectRepository.findAll();
		if(list.size()==0)
			return ResponseEntity.status(204).build();
		return ResponseEntity.status(200).body(list);
	}
	
	// POST METHOD
		@PostMapping
		public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subjectDTO) {
			
			if(subjectDTO.getName()==null || subjectDTO.getStudentID()==null)
				return ResponseEntity.status(409).build();
			
			Optional<Student> studentOptional = studentRepository.findById(subjectDTO.getStudentID());
			Student student = studentOptional.get();
			
			
			if(subjectRepository.findByName(subjectDTO.getName())!=null) 
				return ResponseEntity.status(409).build();
			
			// create new subject

			
			Subject subject = new Subject(
						null, 
						subjectDTO.getName(), 
						student,
						null,
						null
					);
			List <Subject> listSubject = studentRepository.findById(subjectDTO.getStudentID()).get().getListSubjects();
			
			listSubject.add(subject);
			studentRepository.findById(subjectDTO.getStudentID()).get().setListSubjects(listSubject);
			
			Subject newSubject = subjectRepository.save(subject);
			return ResponseEntity.status(201).body(newSubject);
		}
		
		@GetMapping("/{subjectID}")
		public ResponseEntity<?> getSubjectById(@PathVariable("subjectID") Integer subjectID) {
			Optional<Subject> subject = subjectRepository.findById(subjectID);
			return ResponseEntity.status(200).body(subject.get());
		}
		
		@PatchMapping("/{subjectID}")
		public ResponseEntity<?> editSubjectById(@PathVariable("subjectID") Integer subjectID,
					@RequestBody SubjectDTO subjectDTO) 
		{
			
			// Check if subject is already exist

//			if(!(subjectRepository.findByName(subjectDTO.getName()).getId().equals(subjectID))) 
//				return ResponseEntity.status(409).build();
			
			// get subject and student by id
			Optional<Subject> subjectOptional = subjectRepository.findById(subjectID);
			Subject subject = subjectOptional.get();
			
			Optional<Student> studentOptional = studentRepository.findById(subjectDTO.getStudentID());
			if(!studentOptional.isPresent())
				return ResponseEntity.status(409).build();
			Student student = studentOptional.get();
			
			// edit subject
			subject.setName(subjectDTO.getName());
			subject.setStudent(student);
			Subject newSubject = subjectRepository.save(subject);
			return ResponseEntity.status(200).body(newSubject);
		}
		
		@DeleteMapping("/{subjectID}")
		public ResponseEntity<?> deleteSubjectById(@PathVariable("subjectID") Integer subjectID) {	
			subjectRepository.deleteById(subjectID);
			return ResponseEntity.status(200).build();
		}
}
