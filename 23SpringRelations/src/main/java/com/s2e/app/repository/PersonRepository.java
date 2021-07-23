package com.s2e.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2e.app.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
