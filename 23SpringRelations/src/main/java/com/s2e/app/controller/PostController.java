package com.s2e.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.app.model.Post;
import com.s2e.app.repository.PostRepository;

@RestController
public class PostController {
	@Autowired
	PostRepository repo;
	
	@GetMapping("/posts")
	public Collection<Post> getPosts(){
		return repo.findAll();
		
	}

}
