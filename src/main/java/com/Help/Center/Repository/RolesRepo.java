package com.Help.Center.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Help.Center.Models.Roles;

public interface RolesRepo extends JpaRepository<Roles,Integer> {
	Roles  findByRoleName(String roleName);

}
