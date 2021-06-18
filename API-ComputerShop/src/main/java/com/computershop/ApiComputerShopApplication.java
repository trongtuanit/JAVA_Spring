package com.computershop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cloudinary.Cloudinary;
import com.computershop.dao.Delivery;
import com.computershop.dao.User;
import com.computershop.repositories.DeliveryRepository;
import com.computershop.repositories.UserRepository;

@SpringBootApplication
public class ApiComputerShopApplication implements CommandLineRunner {
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

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(cloudinaryUrl);
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
		
		  if (deliveryRepository.count() == 0) {
	            Delivery delivery1 = new Delivery( null, "DaThemVaoGio", "Đã thêm vào giỏ", null, null, null);
	            Delivery delivery2 = new Delivery(null, "ChoXacNhan", "Chờ xác nhận", null, null, null);
	            Delivery delivery3 = new Delivery(null, "DangGiaoHang", "Đang giao hàng", null, null, null);
	            Delivery delivery4 = new Delivery(null, "DaGiao", "Đã giao", null, null, null);
	            Delivery delivery5 = new Delivery(null, "DaHuy", "Đã hủy", null, null, null);
	            deliveryRepository.saveAll(Arrays.asList(delivery1, delivery2, delivery3, delivery4, delivery5));
	        }

	}

}
