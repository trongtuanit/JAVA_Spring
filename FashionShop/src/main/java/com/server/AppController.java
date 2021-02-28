package com.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.server.entities.User;

@RestController
public class AppController {
	@Value("${url.abc}") 
	private String loremUrl;
	
	@GetMapping("/")
	public String home() {
		return "hello";
	}
	@GetMapping("/{id}")
	public String home(@PathVariable("id") String ID) {
		return ID;
	}
	
	@GetMapping("/users")
	public List<User> getUsers(@RequestParam(name = "name", required = false) String nameSearch,
						   @RequestParam(name = "ID", required = false) Integer id) {
		
		List <User> listUser = new ArrayList<>();
		listUser.add(new User(1,"tuan","231"));
		listUser.add(new User(2,"thanh","312"));
		listUser.add(new User(3,"vu","123"));
		
		if(nameSearch!=null) {
			List <User> listUserSearched = new ArrayList<>();
			for(int i = 0; i < listUser.size(); ++i) {
				if(listUser.get(i).getUsername().toLowerCase().contains(nameSearch.toLowerCase()) 
				   && listUser.get(i).getId()==id)
					listUserSearched.add(listUser.get(i));
			}
			if(listUserSearched.size()!=0)
				return listUserSearched;
			return null;
			
		}
		
		return listUser;
	}
	
	
	@PostMapping("/users/create")
	public User createNewPerson(@RequestBody User user) {
		System.out.println(user);
		return user;
	}
}

