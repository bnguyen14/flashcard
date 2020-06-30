package com.flashcard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flashcard.model.User;
import com.flashcard.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping(path="/login")
	public ResponseEntity<User> login(@RequestBody User user){
		User userResult = userRepo.findUserByLogin(user.getUserName(), user.getPassWord());
		
		return new ResponseEntity<User>(userResult, HttpStatus.OK);
	}
	
}
