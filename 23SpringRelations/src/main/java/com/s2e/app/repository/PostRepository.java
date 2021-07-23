package com.s2e.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2e.app.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	

}
