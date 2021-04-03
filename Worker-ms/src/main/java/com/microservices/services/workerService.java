package com.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.entities.worker;
import com.microservices.repositories.workerRepository;

import javassist.NotFoundException;


@Service
public class workerService {
	
	@Autowired
	private workerRepository repository;
	
	
	public void insertWorker(worker worker) {
		repository.saveAndFlush(worker);
	}
	
	public void deleteWorker(String email) {
		repository.deleteByEmail(email);
	}
	
	public double getSalary(String email) {
		return repository.findByEmail(email).getSalary();
	}

	public List<worker> findAll(){
		return repository.findAll();
	}
	
	public worker findByEmail(String email) throws NotFoundException {
		if(repository.findByEmail(email) != null) {
			return repository.findByEmail(email);
		} else {
			return null;
		}
	}
}
