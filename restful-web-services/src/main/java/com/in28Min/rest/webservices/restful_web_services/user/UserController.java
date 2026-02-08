package com.in28Min.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


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
		User createdUser = userDaoService.addUser(user);
		
		/*
		 *  fromCurrentRequest(): will give baseURL/users (here baseURL = http://localhost:8080)
		 *  .path("/{id}") : will add this string to the path ==> baseURL/users/{id}
		 *  .buildAndExpand() : will replace id variable to the created user's Id
		 *  .toUri will convert it to uri
		 *  
		 *  
		 *  Result : Check header of response: you will get a location like this: http://localhost:8080/users/4
		 */
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdUser.getId())
				.toUri();   
		
		return ResponseEntity.created(location).build();
	}
	

}
