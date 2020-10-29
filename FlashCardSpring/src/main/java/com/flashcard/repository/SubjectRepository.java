package com.flashcard.repository;

import org.springframework.data.repository.CrudRepository;

import com.flashcard.model.Subject;

public interface SubjectRepository  extends CrudRepository<Subject, Integer> {

}
