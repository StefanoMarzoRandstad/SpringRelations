package com.s2e.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2e.app.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
