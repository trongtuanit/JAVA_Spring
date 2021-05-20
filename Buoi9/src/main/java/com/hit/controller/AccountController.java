package com.hit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hit.dto.AccountDTO;
import com.hit.modals.Account;
import com.hit.repositories.AccountRepository;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
 
	@Autowired
	private AccountRepository accountRepos;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		List <Account> accounts = accountRepos.findAll();
		return ResponseEntity.status(200).body(accounts);
	}
	
	@PostMapping
	public ResponseEntity<?> createOne(@RequestBody AccountDTO accountDTO) {
		Account account = new Account();
		account.setUsername(accountDTO.getUsername());
		account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
		return ResponseEntity.status(200).build();
	}
	
	
	
}
