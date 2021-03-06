package com.microservices.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.enities.User;
import com.microservices.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(path = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		if (service.findById(id) != null) {
			return ResponseEntity.ok().body(service.findById(id));
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<User> findByEmail(@RequestParam("email") String email) {
		if (service.findByEmail(email) != null) {
			return ResponseEntity.ok().body(service.findByEmail(email));
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
}
