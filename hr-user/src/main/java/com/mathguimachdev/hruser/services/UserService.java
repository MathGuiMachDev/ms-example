package com.mathguimachdev.hruser.services;

import com.mathguimachdev.hruser.entities.User;
import com.mathguimachdev.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
    private UserRepository rep;

    public List<User> findAll() {
        return rep.findAll();
    }

    public User findById(Long id){
        Optional<User> opt = rep.findById(id);
        return opt.get();
    }

    public User findByEmail(String email){
        Optional<User> opt = rep.findByEmail(email);
        return opt.get();
    }
}