package com.flashcard.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	@OneToMany(mappedBy="subject")
	private List<FlashCard> flashcards;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<FlashCard> getFlashcards() {
		return flashcards;
	}
	public void setFlashcards(List<FlashCard> flashcards) {
		this.flashcards = flashcards;
	}
	public Subject(int id, String name, User user, List<FlashCard> flashcards) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.flashcards = flashcards;
	}
	public Subject() {
		super();
	}
	
}
