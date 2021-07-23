package com.s2e.app.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "STREETNAME")
	private String streetName;
	@Column(name = "STREETNUMBER")
	private String streetNumber;
	@Column(name = "POSTALCODE")
	private int postalCode;
	@Column(name = "CITY")
	private String city;
	@Column(name = "COUNTRY")
	private String country;
	// Devo mettere qui il nome dell' attributo in persona e che si riferisce a
	// questo
	@OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
	private Person person;

	public Address(int id, String streetName, String streetNumber, int postalCode, String city, String country,
			Person person) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public Address() {

	}

	public Address(int id, String streetName, String streetNumber, int postalCode, String city, String country) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

}
