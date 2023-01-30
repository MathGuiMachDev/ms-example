package com.mathguimachdev.hroauth.services;

import com.mathguimachdev.hroauth.entities.feign.User;
import com.mathguimachdev.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class OAuthUserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(OAuthUserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email){
        User obj = userFeignClient.findByEmail(email).getBody();
        if(obj == null){
            logger.error("Email not found: "+email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: "+email);
        return obj;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User obj = userFeignClient.findByEmail(username).getBody();
        if(obj == null){
            logger.error("Email not found: "+username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email found: "+username);
        return obj;
    }
}
