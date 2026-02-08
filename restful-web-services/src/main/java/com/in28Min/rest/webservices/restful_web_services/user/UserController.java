package com.in28Min.rest.webservices.restful_web_services.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private UserDaoService userDaoService;
	
	public UserController(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	@GetMapping(path = "users")
	public List<User> getAllUsers() {
		return userDaoService.findAllUsers();
	}
	
	@GetMapping(path = "users/{id}")
	public User getUserById(@PathVariable int id) {
		return userDaoService.findUser(id);
	}
	
	@PostMapping(path = "users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		userDaoService.addUser(user);
		
		return ResponseEntity.created(null).build();
	}
	

}
