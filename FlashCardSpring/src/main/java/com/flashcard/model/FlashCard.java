package com.flashcard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FlashCard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String subject;
	private String question;
	private String answer;
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public FlashCard(int id, String question, String subject, String answer, User user) {
		super();
		this.id = id;
		this.question = question;
		this.subject = subject;
		this.answer = answer;
		this.user = user;
	}
	public FlashCard() {
		super();
	}
	
}
