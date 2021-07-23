package com.s2e.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.app.model.Address;

import com.s2e.app.repository.AddressRepository;

@RestController
public class AddressController {

	@Autowired
	AddressRepository repo;

	@GetMapping("/addresses")
	public Collection<Address> getAddresses() {
		return repo.findAll();

	}
}
