package com.hit.dto;



public class SubjectDTO {
	private Integer studentID;
	private String name;

	public String getName() {
		return name;
	}
	
	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public SubjectDTO(Integer studentID, String name) {
		super();
		this.studentID = studentID;
		this.name = name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public SubjectDTO() {
		super();
	}

	
	
}
