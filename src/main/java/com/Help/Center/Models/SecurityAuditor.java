package com.Help.Center.Models;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class SecurityAuditor implements AuditorAware<String> {
	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.ofNullable("Admin").filter(s -> !s.isEmpty());
	}

}
