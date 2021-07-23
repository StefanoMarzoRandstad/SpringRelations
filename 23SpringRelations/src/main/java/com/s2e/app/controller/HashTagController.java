package com.s2e.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.app.model.HashTag;

import com.s2e.app.repository.HashTagRepository;

@RestController
public class HashTagController {

	@Autowired
	HashTagRepository repo;

	@GetMapping("/hashtags")
	public Collection<HashTag> getHashTags() {
		return repo.findAll();

	}
}
