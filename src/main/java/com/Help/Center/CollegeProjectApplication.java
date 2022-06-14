package com.Help.Center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Help.Center.Models.SecurityAuditor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@CrossOrigin(origins = "*")
public class CollegeProjectApplication {
	@Bean
	public AuditorAware<String>auditorAware(){
		return new SecurityAuditor();
	}

	public static void main(String[] args) {
		SpringApplication.run(CollegeProjectApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}


}	
