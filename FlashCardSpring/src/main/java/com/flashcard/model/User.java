package com.flashcard.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(unique=true)
	private String userName;
	@Column(unique=true)
	private String email;
	private String passWord;
	@OneToMany(mappedBy="user")
	private List<Subject> subjects;
	@OneToMany(mappedBy="user")
	private List<FlashCard> flashcards;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public List<FlashCard> getFlashcards() {
		return flashcards;
	}
	public void setFlashcards(List<FlashCard> flashcards) {
		this.flashcards = flashcards;
	}
	public User(int id, String userName, String email, String passWord, List<Subject> subjects,
			List<FlashCard> flashcards) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.subjects = subjects;
		this.flashcards = flashcards;
	}
	public User() {
		super();
	}
	
}

