package com.example.vkTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.vkTest.model.Role;
import com.example.vkTest.model.User;
import com.example.vkTest.repository.UserRepository;

@SpringBootApplication
public class VkTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(VkTestApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runner(UserRepository userRepository) {
	// return args -> {
	// Role role = new Role("ADMIN");
	// Set<Role> rol = new HashSet<>();
	// rol.add(role);
	// User user = new User("Ivan", "password1", rol);

	// userRepository.insert(user);

	// };

	// }

}
