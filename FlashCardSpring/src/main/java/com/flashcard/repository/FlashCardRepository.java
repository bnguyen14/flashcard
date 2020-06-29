package com.flashcard.repository;

import org.springframework.data.repository.CrudRepository;
import com.flashcard.model.FlashCard;

public interface FlashCardRepository extends CrudRepository<FlashCard, Integer> {
	
}
