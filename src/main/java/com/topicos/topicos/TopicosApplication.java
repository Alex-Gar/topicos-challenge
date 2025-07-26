package com.topicos.topicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TopicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopicosApplication.class, args);
	}

	// public static void main(String[] args) {

	// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	// System.out.println("Password: " + encoder.encode("123456789"));
	// }

}
