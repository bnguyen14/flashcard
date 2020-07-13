package com.flashcard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.flashcard.model.User;

public interface UserRepository extends CrudRepository<User, Integer>  {
	
	@Query(value="select * from user u where u.user_name = ?1 and u.pass_word = ?2", nativeQuery=true)
	User findUserByLogin(String username, String Password);
	
	@Query(value="select user_name from user u where u.user_name = ?1", nativeQuery=true)
	boolean findUsername(String username);
	
	@Query(value="select email from user u where u.email = ?1", nativeQuery=true)
	boolean findEmail(String email);
}
