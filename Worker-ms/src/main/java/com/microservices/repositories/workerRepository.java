package com.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.entities.worker;

@Repository
public interface workerRepository extends JpaRepository<worker, Long>{

	worker findByEmail(String email);
	void deleteByEmail(String email);
	
}
