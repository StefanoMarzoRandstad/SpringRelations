package com.s2e.app.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.app.model.Address;
import com.s2e.app.model.HashTag;
import com.s2e.app.model.Person;
import com.s2e.app.model.Post;
import com.s2e.app.repository.PersonRepository;



@RestController
public class PersonController {
	
	@Autowired
	PersonRepository repo;
	
	@GetMapping("/persons")
	public Collection<Person> getPersons(){
		return repo.findAll();
		
	}
	
	@GetMapping("/person/{id}/address")
	public Address getPersonAddress(@PathVariable("id") int id) {
		return repo.getById(id).getAddress();
	}
	
	@GetMapping("person/{id}/posts")
	public Collection<Post> getPersonPosts(@PathVariable("id") int id) {
		return repo.getById(id).getPosts();
	}
	
	@GetMapping("person/{id}/hashtags")
	public Collection<HashTag> getPersonHashtags(@PathVariable("id") int id) {
		Set<HashTag> hashtagList = new HashSet<>();
		Collection<Post> personPosts = getPersonPosts(id);
		for(Post p: personPosts)
			for(HashTag h: p.getHashtags())
				hashtagList.add(h);
		return hashtagList;
	}

}
