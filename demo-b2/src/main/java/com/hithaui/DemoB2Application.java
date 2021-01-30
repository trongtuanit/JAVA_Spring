package com.hithaui;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoB2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoB2Application.class, args);
		
//		ConfigurableApplicationContext context = SpringApplication.run(DemoB2Application.class, args);
		
//		Cat cat = context.getBean(Cat.class);
//		
//		System.out.println(cat);
//		
//		cat.Eat();

//		Animal animal = context.getBean(Animal.class);
		
//		System.out.println(animal);
		
	}

}
