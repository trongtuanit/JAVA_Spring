package com.hit.dto;

public class DistrictDTO {

	private String name;
	
	private String type;

	private String code;
	
	private String parentCode;

	public DistrictDTO(String name, String type, String code, String parentCode) {
		super();
		this.name = name;
		this.type = type;
		this.code = code;
		this.parentCode = parentCode;
	}

	public DistrictDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

}
