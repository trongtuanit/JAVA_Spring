package com.hit.dto;

import java.util.List;

public class ProvinceConnectionDTO {
	private List <ProvinceDTO> provinceDTOs;

	public List<ProvinceDTO> getProvinceDTOs() {
		return provinceDTOs;
	}

	public void setProvinceDTOs(List<ProvinceDTO> provinceDTOs) {
		this.provinceDTOs = provinceDTOs;
	}

	public ProvinceConnectionDTO(List<ProvinceDTO> provinceDTOs) {
		super();
		this.provinceDTOs = provinceDTOs;
	}

	public ProvinceConnectionDTO() {
		super();
	}
	
	
}
