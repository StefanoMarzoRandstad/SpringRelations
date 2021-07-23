package com.s2e.app.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*
 * Considera l'identificatore come chiave esterna, serve per evitare i loop
 */
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String text;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;
	@ManyToMany(fetch = FetchType.LAZY)
	// Costruisco la tabella relazionale
	@JoinTable(name = "post_hashtag", 
	joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "hashtag_id", referencedColumnName = "id"))
	private List<HashTag> hashtags;

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post() {

	}

	public Post(int id, String text, Person person) {
		super();
		this.id = id;
		this.text = text;
		this.person = person;

	}

	public List<HashTag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<HashTag> hashtags) {
		this.hashtags = hashtags;
	}

}
