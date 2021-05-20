package com.hit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hit.dto.AccountDTO;
import com.hit.dto.AuthenticationResponse;
import com.hit.services.MyUserDetailsService;
import com.hit.utils.JwtUtil;

@RestController
@RequestMapping("/auth/login")
public class AuthController {
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody AccountDTO accountDTO) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountDTO.getUsername(), accountDTO.getPassword()));
		} catch (Exception e) {
			throw new Exception("incorrect");
		}
		
		UserDetails userDetails = myUserDetailsService.loadUserByUsername(accountDTO.getUsername());
		String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.status(200).body(new AuthenticationResponse(jwt));
	}
}
