package com.s2e.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.app.model.Person;
import com.s2e.app.repository.PersonRepository;



@RestController
public class PersonController {
	
	@Autowired
	PersonRepository repo;
	
	@GetMapping("/persons")
	public Collection<Person> getPersons(){
		return repo.findAll();
		
	}

}
