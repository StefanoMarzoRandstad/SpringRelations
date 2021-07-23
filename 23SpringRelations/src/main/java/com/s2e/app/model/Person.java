package com.s2e.app.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String mail;
	
	@OneToOne(fetch = FetchType.LAZY)
	// Attributo che deve avere la persona su cui si fa la join
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
	private List<Post> posts;

	
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person() {

	}


	public Person(int id, String name, String surname, String mail, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.address = address;
	}

	
	public Person(int id, String name, String surname, String mail, Address address, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.address = address;
		this.posts = posts;
	}



	
}
