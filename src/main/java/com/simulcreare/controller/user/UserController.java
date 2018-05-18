package com.simulcreare.controller.user;

import com.simulcreare.domain.dto.UserRegistration;
import com.simulcreare.domain.entity.User;
import com.simulcreare.respository.UserRepository;
import com.simulcreare.service.user.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRegistrationService registrationService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserRegistration registration) {
        User user = registrationService.toEntity(registration);
        userRepository.save(user);
    }

    @RequestMapping(value = "/mail-is-free/{mail}", method = RequestMethod.GET)
    public Boolean mailIsFree(@PathVariable String mail) {
        return userRepository.findOneByMail(mail) != null;
    }
}
