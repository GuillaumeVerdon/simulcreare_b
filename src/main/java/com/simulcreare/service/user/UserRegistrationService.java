package com.simulcreare.service.user;

import com.simulcreare.domain.dto.UserRegistration;
import com.simulcreare.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User toEntity(UserRegistration registration) {
        User entity = new User();

        entity.setMail(registration.getMail());
        entity.setPasshash(passwordEncoder.encode(registration.getPassword()));

        return entity;
    }
}
