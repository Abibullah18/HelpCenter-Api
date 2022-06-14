package com.Help.Center.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Help.Center.Models.Scope;

public interface ScopeRepo extends JpaRepository<Scope, Integer> {
	Scope findByScopeName(String scopeName);

}
