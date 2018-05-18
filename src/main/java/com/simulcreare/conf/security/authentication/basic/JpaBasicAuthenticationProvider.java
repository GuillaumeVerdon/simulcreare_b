package com.simulcreare.conf.security.authentication.basic;

import com.simulcreare.domain.entity.User;
import com.simulcreare.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JpaBasicAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String candidateMail = authentication.getPrincipal().toString();
        String candidateRawPassword = authentication.getCredentials().toString();

        User authenticatedUser = userRepository.findOneByMail(candidateMail);

        if(authenticatedUser == null) {
            return null;
        }

        if(!passwordEncoder.matches(candidateRawPassword, authenticatedUser.getPasshash())) {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(authenticatedUser.getMail(), authenticatedUser.getPasshash(), new ArrayList<>()); //todo: Add authorities
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
