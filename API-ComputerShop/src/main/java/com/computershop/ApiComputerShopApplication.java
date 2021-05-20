package com.computershop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class ApiComputerShopApplication {
	@Value("${cloudinary.cloud_name}")
	private String cloudName;

	@Value("${cloudinary.api_key}")
	private String apiKey;

	@Value("${cloudinary.api_secret}")
	private String apiSecret;
	
	@Value("${cloudinary.url}")
	private String cloudinaryUrl;
	
	@Bean
	public Cloudinary cloudinaryConfig() {
		Cloudinary cloudinary = new Cloudinary(cloudinaryUrl);;
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

}
