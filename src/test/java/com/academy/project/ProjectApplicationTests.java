package com.academy.project;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.academy.project.security.BCryptEncoder;

@SpringBootTest
class ProjectApplicationTests {

	@Test
	void contextLoads() {
		String pass = BCryptEncoder.encode("pass");
		System.out.println(pass);
		assertNotNull(pass);
	}

}
