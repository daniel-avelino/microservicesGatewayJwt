package com.microservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.entities.worker;
import com.microservices.services.workerService;

import javassist.NotFoundException;

@RestController
@RequestMapping(path = "/workers")
public class workerController {

	@Autowired
	private workerService services;

	@GetMapping
	public ResponseEntity<List<worker>> findAll() {
		return ResponseEntity.ok().body(services.findAll());
	}

	@PostMapping
	public ResponseEntity<worker> insertWorker(@RequestBody worker worker) {
		services.insertWorker(worker);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(path = "/find")
	public ResponseEntity<worker> findByEmail(@RequestParam("email") String email) throws NotFoundException {
		worker worker = services.findByEmail(email);
		if (worker == null) {
			return new ResponseEntity<worker>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok().body(services.findByEmail(email));
		}
	}
}
