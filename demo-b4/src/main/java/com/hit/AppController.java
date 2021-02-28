package com.hit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@Value("${url.abc}")
	private String url;
	
	@GetMapping("/") 
	public String home() {
		System.out.println(url);
		return "hello";
		
	}
	
	
	@GetMapping("/{id}")
	public String home(@PathVariable("id") String iD) {
		System.out.println(iD);
		return "a";
	}
	
	@GetMapping("/users") 
	public List<Person> users(@RequestParam(name = "name", required = false) String nameSearch,
			@RequestParam(name = "age", required = false) Integer age) 
	{
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("tuan", 20));
		list.add(new Person("thanh", 2));
		list.add(new Person("vu", 3));
		
		if(nameSearch!=null) {
			List<Person> listSearchByName = new ArrayList<Person>();
			for(int i = 0; i < list.size(); ++i) {
				if(list.get(i).getName().toLowerCase().contains(nameSearch.toLowerCase()) 
				   && list.get(i).getAge()==age)
					listSearchByName.add(list.get(i));
			}
			if(listSearchByName.size() > 0) {
				return listSearchByName;
			}
			else
				return null;
			
		}
		if(list.size()==0)
			throw new NotFoundException("Khong co du lieu!");
		
		return list;
	}
	
	@PostMapping("/users/create")
	public Person createNewPerson(@RequestBody Person person) {
		System.out.println(person);
		return person;
	}
	
	
	
}
