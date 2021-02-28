package com.hit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hit.dao.Account;
import com.hit.repositories.AccountRepositories;

@RestController
public class AccountController {
	@Autowired
	private AccountRepositories accountRepository;
	
	@GetMapping("/accounts")
	public List<Account> getAllAccount() {
		List<Account> list = accountRepository.findAll();
		return list;
	}
}

