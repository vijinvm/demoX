package com.example.demoX;

import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder {

    public String encodePassword(String password) {
        return password + "_hashed"; 
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return encodePassword(rawPassword).equals(encodedPassword);
    }
}
