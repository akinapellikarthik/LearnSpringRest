package com.karthik.webservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.karthik.webservice.exception.UserNotFoundException;
import com.karthik.webservice.userVo.User;
import com.karthik.webservice.userservice.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/findUser/{userId}")
	public User findOneController(@PathVariable Integer userId) throws UserNotFoundException {
		User u = userService.findOneByIdFromDAO(userId);
		if(u == null) {
			throw new UserNotFoundException("USER NOT FOUND IN DATABASE......");
		}
		return u;
	}

	@PostMapping("/createUser")
	public ResponseEntity<User> saveUserController(@RequestBody User user) {
		User u = userService.saveOneUserFromService(user);
		URI location = null;
		location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getUserId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@GetMapping(path = "/getAllUsers")
	public List<User> findAllController() {
		return userService.findAllUsersFromDAO();
	}
}
