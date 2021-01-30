package com.hithaui;

import org.springframework.stereotype.Component;

@Component //Quantrong
public class Cat {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}

	public Cat(String name) {
		super();
		this.name = name;
	}
	
	public Cat() {
		
	}
	
	public void Eat() {
		System.out.println("Thịt mèo xào xả ớt");
	}
}
