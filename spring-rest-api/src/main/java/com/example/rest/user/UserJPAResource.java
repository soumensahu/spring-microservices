package com.example.rest.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAResource {

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping(path="/jpa/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping(path="/jpa/users/{id}")
	public Resource<User> getUserById(@PathVariable Integer id) {
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id : "+id);
		Resource<User> resource=new Resource<User>(user.get());
		ControllerLinkBuilder linkTo= linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-user"));
		return resource;
	}
	
	@PostMapping(path="/jpa/users/{id}/posts")
	public ResponseEntity<Object> createUser(@PathVariable Integer id,@Valid @RequestBody Post post) {
		Optional<User> userOptional=userRepository.findById(id);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("id : "+id);
		
		User user=userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		URI location= ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/jpa/users/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	

	@GetMapping(path="/jpa/users/{id}/posts")
	public List<Post> getAllPosts(@PathVariable Integer id){
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id : "+id);
		return user.get().getPosts();
	}
}
