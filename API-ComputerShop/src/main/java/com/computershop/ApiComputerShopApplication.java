package com.computershop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cloudinary.Cloudinary;
import com.computershop.dao.User;
import com.computershop.repositories.UserRepository;

@SpringBootApplication
public class ApiComputerShopApplication implements CommandLineRunner {
	@Value("${cloudinary.cloud_name}")
	private String cloudName;

	@Value("${cloudinary.api_key}")
	private String apiKey;

	@Value("${cloudinary.api_secret}")
	private String apiSecret;

	@Value("${cloudinary.url}")
	private String cloudinaryUrl;

	@Value("${user.first_name}")
	private String firstName;

	@Value("${user.last_name}")
	private String lastName;

	@Value("${user.username}")
	private String username;

	@Value("${user.password}")
	private String password;

	@Value("${user.address}")
	private String address;

	@Value("${user.role}")
	private String role;

	@Value("${user.email}")
	private String email;

	@Value("${user.phone}")
	private String phone;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public Cloudinary cloudinaryConfig() {
		Cloudinary cloudinary = new Cloudinary(cloudinaryUrl);
		;
		Map<String, String> config = new HashMap<String, String>();
		config.put("cloud_name", cloudName);
		config.put("api_key", apiKey);
		config.put("api_secret", apiSecret);
		cloudinary = new Cloudinary(config);
		return cloudinary;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiComputerShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.count() == 0) {
			User admin = new User(null, firstName, lastName, username, passwordEncoder.encode(password), address, null,
					phone, email, role, null, null);
			userRepository.save(admin);
			System.out.println(username+ " account has been created!");
		}

	}

}
