package com.server.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.server.entities.User;
import com.server.repositories.UserRepositories;


@RestController
public class UserController {
	@Autowired
	private UserRepositories userRepository;
	
	@GetMapping("/users")
	public List<User> getAllAccount() {
		List<User> listUser = userRepository.findAll();
		return listUser;
	}
	public List<User> getUsers(@RequestParam(name = "name", required = false) String nameSearch,
			   @RequestParam(name = "ID", required = false) Integer id) {
		
		List <User> listUser = new ArrayList<>();
		return listUser;
	}
}
