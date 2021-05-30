package com.computershop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HelloController {
	
	@GetMapping
	public String helloWorld() {
		return " Login: \r\n" + 
				"POST method: https://computer-shop-hit.herokuapp.com/api/auth/login\r\n" + 
				"Post lên body có dạng\r\n" + 
				"{\r\n" + 
				"“username”: “*****”,\r\n" + 
				"“password”: “*****”\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"SignUp\r\n" + 
				"Post method: https://computer-shop-hit.herokuapp.com/api/auth/signup\r\n" + 
				"Post lên body có dạng: \r\n" + 
				"{\r\n" + 
				"“firstName”:”******”,\r\n" + 
				"“lastName”:”********”,\r\n" + 
				"“username”:”*******”,\r\n" + 
				"“password”:”*****”,\r\n" + 
				"“address”:”******”,\r\n" + 
				"“phone”:”*********”,\r\n" + 
				"“email”:”*******”,\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"Forgot password\r\n" + 
				"https://computer-shop-hit.herokuapp.com/api/auth/forgot-password\r\n" + 
				"Post lên body có dạng: \r\n" + 
				"{\r\n" + 
				"     	“userId”: (number),\r\n" + 
				"	“username”: “******” \r\n" + 
				"}\r\n" + 
				"Hệ thống tự tạo và gửi pass mới về mail người dùng\r\n" + 
				"";
	}
}
