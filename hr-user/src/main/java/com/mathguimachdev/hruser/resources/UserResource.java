package com.mathguimachdev.hruser.resources;

import com.mathguimachdev.hruser.entities.User;
import com.mathguimachdev.hruser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService serv;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = serv.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		User obj = serv.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
}
