package com.hit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hit.dao.AccountDAO;
import com.hit.dto.AccountDTO;
import com.hit.repositories.AccountRepositories;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepositories accountRepository;
	
	//GET
	@GetMapping
	public ResponseEntity<?> getAllAccount(@RequestParam(value="page", required = false) Integer page) {
		
		if(page!=null) {
			Page<AccountDAO> listAccountOfPage = accountRepository.findAll(PageRequest.of(page.intValue(),10));
			List<AccountDAO> listAccounts = listAccountOfPage.getContent();
			ResponseEntity.status(200).body(listAccounts);
		}

		
		List <AccountDAO> list = accountRepository.findAll();
		if(list.size()==0)
			return ResponseEntity.status(204).build();
		return ResponseEntity.status(200).body(list);
	}
	//POST
	@PostMapping
	public ResponseEntity<?> createNewAccount(@RequestBody AccountDTO accountDTO){
		
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.setUsername(accountDTO.getUsername());
		accountDAO.setPassword(accountDTO.getPassword());
		
		AccountDAO usernameInvalid = accountRepository.findByUsername(accountDAO.getUsername());
		if(accountDTO.getUsername().toLowerCase().equals(usernameInvalid.getUsername().toLowerCase())==true) {
			return ResponseEntity.status(409).build();
//			throw 
		}

		AccountDAO newAccountDAO = accountRepository.save(accountDAO);
		return ResponseEntity.status(201).body(newAccountDAO);

		
	}
	
	@GetMapping("/{accountID}")
	public ResponseEntity<?> getAccountById(@PathVariable("accountId") Long accountId) {
		Optional<AccountDAO> accountDAO = accountRepository.findById(accountId);
		
		return ResponseEntity.status(200).body(accountDAO.get());
	}
	
	@PatchMapping("/{accountID}")
	public ResponseEntity<?> editAccountById(@PathVariable("accountId") Long accountId,
				@RequestBody AccountDTO accountDTO) {
		Optional<AccountDAO> optional = accountRepository.findById(accountId);
		AccountDAO accountDAO = optional.get();
		accountDAO.setPassword(accountDTO.getPassword());
		AccountDAO newaAccountDAO = accountRepository.save(accountDAO);
		return ResponseEntity.status(200).body(newaAccountDAO);
	}
	
//	@GetMapping
//	public ResponseEntity<?> getAccountByPagination(@RequestParam(value="page", required = false) Integer page){
//		Page<AccountDAO> listAccountOfPage = accountRepository.findAll(PageRequest.of(page.intValue(),10));
//		List<AccountDAO> listAccount = listAccountOfPage.getContent();
//		return null;
//	}

	@DeleteMapping("/{accountID}")
	public ResponseEntity<?> deleteAccountById(@PathVariable("accountId") Long accountId) {
//		Optional<AccountDAO> accountDAO = accountRepository.findById(accountId);
		
		accountRepository.deleteById(accountId);
		return ResponseEntity.status(200).build();
	}
	
}
