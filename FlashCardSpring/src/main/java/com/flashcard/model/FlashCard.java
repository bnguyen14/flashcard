package com.flashcard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlashCard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String question;
	private String answer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public FlashCard(int id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}
	public FlashCard() {
		super();
	}
	
}
