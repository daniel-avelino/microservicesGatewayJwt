package com.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.microservices.repositories.UserRepository;
import com.microservices.enities.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

	public User findById(Long id) {
		return repository.findById(id).get();
	}

	public boolean login(User user) {
		User userLogin = repository.findByEmail(user.getEmail());

		if (userLogin.getPassword() == user.getPassword()) {
			return true;
		} else {
			return false;
		}
	}

}
