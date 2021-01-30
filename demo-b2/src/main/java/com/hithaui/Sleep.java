package com.hithaui;

import org.springframework.stereotype.Component;

@Component //tạo bean
public class Sleep {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void Sleep(String name) {
		this.name = name;
	}
	
}
