package com.in28Min.rest.webservices.restful_web_services.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28Min.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;


@RestController
public class UserJpaController {
	
	private UserRepository userRepository;
	
	public UserJpaController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping(path = "jpa/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "jpa/users/{id}")
	public EntityModel<User> getUserById(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(user == null)
			throw new UserNotFoundException("id : "+id);
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping(path = "jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User createdUser = userRepository.save(user);
		
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
	
	@DeleteMapping(path = "jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(user == null)
			throw new UserNotFoundException("id : "+id);
		userRepository.deleteById(id);
		
		return;
	}
	

}
