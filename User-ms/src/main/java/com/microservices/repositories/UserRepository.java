package com.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.enities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
