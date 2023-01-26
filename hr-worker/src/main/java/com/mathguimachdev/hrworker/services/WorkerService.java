package com.mathguimachdev.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathguimachdev.hrworker.entities.Worker;
import com.mathguimachdev.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
    private WorkerRepository rep;

    public List<Worker> findAll() {
        return rep.findAll();
    }

    public Worker findById(Long id){
        Optional<Worker> opt = rep.findById(id);
        return opt.get();
    }
}