package com.sid.forum.registrationforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//1. @SpringBootApplication
// SecurityAutoConfiguration.class to disable Auto Security Configuration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//2. Component Scan is used to scan all the component and Services and Controller etc classes
@ComponentScan("com.sid.forum")
//3. EntityScan is only needed for scan all the persistances classes.
@EntityScan(basePackages = { "com.sid.forum.model" })
//4. Explicitly Scan Only JPA Repository
@EnableJpaRepositories(basePackages = { "com.sid.forum.repository" })
@EnableJpaAuditing
public class RegistrationForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationForumApplication.class, args);
	}
}
