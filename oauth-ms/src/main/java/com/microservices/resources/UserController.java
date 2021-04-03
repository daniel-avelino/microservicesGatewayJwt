package com.microservices.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.entities.User;
import com.microservices.services.userService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private userService service;

	@GetMapping(path = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam("email") String email) {
		try {
			return ResponseEntity.ok().body(service.findByEmail(email));

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
