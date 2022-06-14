package com.Help.Center.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Help.Center.Models.Tags;

public interface TagRepo extends JpaRepository<Tags, Integer> {
	Tags findByTagName(String name);

}
