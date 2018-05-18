package com.simulcreare.conf.security.authentication.basic;

import com.simulcreare.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BasicUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.simulcreare.domain.entity.User userDAO = userRepository.findOneByMail(username);

        return new User(userDAO.getMail(), userDAO.getPasshash(), null);
    }
}
