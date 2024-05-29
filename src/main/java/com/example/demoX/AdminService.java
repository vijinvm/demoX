package com.example.demoX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin authenticate(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        
        return null;
    }
}
