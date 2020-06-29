package com.flashcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flashcard.model.FlashCard;
import com.flashcard.repository.FlashCardRepository;

@Controller
@RequestMapping("/flashcard")
public class FlashCardController {
	@Autowired
	private FlashCardRepository fcRepo;
	
	@PostMapping(path="/add")
	public @ResponseBody String addFlashCard(@RequestParam String q, @RequestParam String a) {
		FlashCard fc = new FlashCard();
		fc.setQuestion(q);
		fc.setAnswer(a);
		fcRepo.save(fc);
		return "Added FlashCard";
	}
	
	@GetMapping(path="/getAll")
	public @ResponseBody Iterable<FlashCard> getAllFlashCards(){
		return fcRepo.findAll();
	}
}
