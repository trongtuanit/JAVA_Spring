package com.example.tuanmc;

import org.springframework.stereotype.Component;

@Component
public class Fish implements Animal{
	@Override
	public void move() {
		System.out.println("Swim");
	}
}
