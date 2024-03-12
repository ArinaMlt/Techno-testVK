package com.example.vkTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class VkTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(VkTestApplication.class, args);
	}

}
