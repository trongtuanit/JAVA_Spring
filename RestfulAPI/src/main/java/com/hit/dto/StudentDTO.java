package com.hit.dto;


//import java.sql.Timestamp;
import java.util.List;


public class StudentDTO {

	private String fullName;
	private String phone;
	private List <Integer> listSubjectId;

	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public StudentDTO() {
		super();
	}
	public List<Integer> getListSubjectId() {
		return listSubjectId;
	}
	public void setListSubjectId(List<Integer> listSubjectId) {
		this.listSubjectId = listSubjectId;
	}
	public StudentDTO(String fullName, String phone, List<Integer> listSubjectId) {
		super();
		this.fullName = fullName;
		this.phone = phone;
		this.listSubjectId = listSubjectId;

	}

	
}
