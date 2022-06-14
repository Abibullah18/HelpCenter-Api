 package com.Help.Center.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Help.Center.Models.Articles;

import java.util.List;

 public interface ArticleRepo  extends JpaRepository<Articles, Integer>{
	Articles findByTitle(String title);


	 List<Articles> findAllByDeleted(Boolean value);
 }
