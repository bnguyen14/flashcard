package com.flashcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.flashcard.model.FlashCard;
import com.flashcard.model.User;

public interface FlashCardRepository extends CrudRepository<FlashCard, Integer> {
	@Query(value="select * from flash_card fc where fc.user_id = ?1", nativeQuery=true)
	List<FlashCard> findCardsByUser(int id);
}
