package com.karthik.webservice.springjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.webservice.exception.UserNotFoundException;
import com.karthik.webservice.springjpa.repo.Post;
import com.karthik.webservice.springjpa.repo.User;
import com.karthik.webservice.springjpa.repo.UserRepository;

@RestController
public class UserJpaController {

	@Autowired
	@Qualifier("UserRepo")
	private UserRepository userRepository;

	@GetMapping(path = "/jpa/users")
	@ResponseBody
	public List<User> users() {

		return userRepository.findAll();

	}

	@GetMapping(path = "/jpa/users/{id}")
	@ResponseBody
	public Optional<User> oneUser(@PathVariable Long id) throws UserNotFoundException {

		Optional<User> us = userRepository.findById(id);

		if (!us.isPresent()) {
			throw new UserNotFoundException("User with id:" + id + " is not present in db...");
		}

		return us;

	}
	
	@DeleteMapping(path="/jpa/user/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	
	@PostMapping(path="/jpa/user/create")
	@ResponseBody
	public User insertUser(@RequestBody User u) {
		return userRepository.saveAndFlush(u);
	}
	
	@GetMapping(path="/jpa/user/{id}/posts")
	public List<Post> getPosts(@PathVariable Long id) throws UserNotFoundException{
		
		Optional<User> op = userRepository.findById(id);
		if(!op.isPresent()) {
			
			throw new UserNotFoundException("User with id:" + id + " is not present in db...");
			
		}
		
		return op.get().getPosts();
		
		
	}
	

}
