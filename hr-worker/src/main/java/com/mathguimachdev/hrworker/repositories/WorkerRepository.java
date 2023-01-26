package com.mathguimachdev.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathguimachdev.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

	
	
}
