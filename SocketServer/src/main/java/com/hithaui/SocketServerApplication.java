package com.hithaui;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hithaui.socket.SocketApplication;

@SpringBootApplication
public class SocketServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SocketServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SocketApplication.startSocketApplication();
	}

}
