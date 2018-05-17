package com.simulcreare.conf.security.authentication.basic;

import com.simulcreare.domain.entity.User;
import com.simulcreare.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JpaBasicAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String candidateMail = authentication.getPrincipal().toString();
        String candidateRawPassword = authentication.getCredentials().toString();
        String candidatePasshash = passwordEncoder.encode(candidateRawPassword);

        User authenticatedUser = userRepository.findOneByMailAndPasshash(candidateMail, candidatePasshash);

        if(authenticatedUser == null) {
            return null;
        }

        return null; //Todo finish implem
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return "org.springframework.security.authentication.UsernamePasswordAuthenticationToken".equals(aClass.getName());
    }
}
