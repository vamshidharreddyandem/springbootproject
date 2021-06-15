package com.memorystack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class MemoryStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoryStackApplication.class, args);
	}

}
