package com.example.tuanmc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal{
	
	private String name;
	private int age;
	private String breed;
	
	
	
	
	public Dog() {
		super();
	}

	public Dog(String name, int age, String breed) {
		super();
		this.name = name;
		this.age = age;
		this.breed = breed;
	}
	public void setDog(String name, int age, String breed) {
		this.name = name;
		this.age = age;
		this.breed = breed;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Autowired
	Animal animal;
	
	@Override
	public void move() {
		System.out.println("Walk");
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	

}
