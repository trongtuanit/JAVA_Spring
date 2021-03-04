package com.hit.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import org.springframework.lang.NonNull;

//import com.sun.istack.NotNull;


@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", nullable = false)
//	@NotNull
	private Integer id;

	@Nationalized
	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Column(name = "phone", unique = true, nullable = false)
	private String phone;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	
	private List<Subject> listSubjects;

	@CreationTimestamp
	private Timestamp createAt;

	@UpdateTimestamp
	private Timestamp updateAt;

	public Student() {

	}
	@JsonManagedReference
	public List<Subject> getListSubjects() {
		return listSubjects;
	}

	public void setListSubjects(List<Subject> listSubjects) {
		this.listSubjects = listSubjects;
	}

	public Student(Integer id, String fullName, String phone, List<Subject> listSubjects, Timestamp createAt,
			Timestamp updateAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.listSubjects = listSubjects;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

}