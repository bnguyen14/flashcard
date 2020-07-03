package com.flashcard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.model.User;
import com.flashcard.repository.UserRepository;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping(path="/login")
	public ResponseEntity<User> login(@RequestBody User user){
		System.out.println("user: " + user.getUserName() + ", " + user.getPassWord());
		User userResult = userRepo.findUserByLogin(user.getUserName(), user.getPassWord());
		//System.out.println("result: " + userResult.getUserName() + ", " + userResult.getPassWord());
		
		if(userResult!=null) {
			return new ResponseEntity<User>(userResult,HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(userResult,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PostMapping(path="/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		userRepo.save(user);
		
		return new ResponseEntity<User>(userRepo.findUserByLogin(user.getUserName(), user.getPassWord()),HttpStatus.OK);
	}
}
