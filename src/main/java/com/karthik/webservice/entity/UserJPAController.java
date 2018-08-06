package com.karthik.webservice.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1")
public class UserJPAController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/saveUser")
	public User saveUser(@RequestBody User u) {
		// UserDaoService.saveUser(u);
		return userRepository.save(u);
	}

	@GetMapping(path = "/allUsers")
	@ResponseBody
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping(path = "/findById/{id}")
	public Optional<User> findOne(@PathVariable Long id) {
		return userRepository.findById(id);
	}
}
