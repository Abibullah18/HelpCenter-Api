package com.Help.Center.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Help.Center.Models.Company;

import java.util.List;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
	Company findBycompanyName(String companyName);


	List<Company> findAllByDelete(Boolean value);
}
