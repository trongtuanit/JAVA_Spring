package com.hit.dto;

public class ProvinceDTO {

	private String name;

	private String type;

	private String code;

	public ProvinceDTO(String name, String type, String code) {
		super();
		this.name = name;
		this.type = type;
		this.code = code;
	}

	public ProvinceDTO() {
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

	

}
