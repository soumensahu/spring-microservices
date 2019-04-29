package com.example.rest.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {

	@Autowired
	private UserDAO userDaoService;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> getUserById(@PathVariable Integer id) {
		User user= userDaoService.getUserById(id);
		Resource<User> resource=new Resource<User>(user);
		ControllerLinkBuilder linkTo= linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-user"));
		return resource;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=userDaoService.saveUser(user);
		URI location= ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userDaoService.deleteUserById(id);
	}
}
