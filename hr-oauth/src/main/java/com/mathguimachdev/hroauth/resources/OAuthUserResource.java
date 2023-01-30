package com.mathguimachdev.hroauth.resources;

import com.mathguimachdev.hroauth.entities.feign.User;
import com.mathguimachdev.hroauth.services.OAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class OAuthUserResource {

    @Autowired
    private OAuthUserService serv;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        try{
            User obj = serv.findByEmail(email);
            return ResponseEntity.ok().body(obj);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
