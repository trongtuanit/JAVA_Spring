package com.example.tuanmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TuanmcApplication {
	public static void main(String[] args) {
		SpringApplication.run(TuanmcApplication.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(TuanmcApplication.class, args);
//		Animal animal = context.getBean(Animal.class);
//		
//		System.out.println("Output instance: "+ animal);
//		animal.move();
//		
//		Dog dog = context.getBean(Dog.class);
//		System.out.println("Dog instace: "+dog);
//		
//		dog.animal.move();
	}

}
