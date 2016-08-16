package com.example.controllers;


import com.example.dto.UserAccountDTO;
import com.example.entitys.UserAccount;
import com.example.repository.PaymentRepository;
import com.example.repository.UserRepository;
import com.example.services.PaymentService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController(value = "users")
public class UserController {

    private UserRepository userRepository;
    private PaymentRepository paymentRepository;

    @Autowired
    public UserController(UserRepository userRepository, PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "alles", method = RequestMethod.GET)
    public String findAllUsers() {
        List<UserAccount> all = userRepository.findAll();
        return new UserAccountDTO().getJsonUsserAccountList(all);
    }

    @RequestMapping(method = RequestMethod.GET, value = "users/login")
    public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        if (new UserService(userRepository).login(name, password)) {
            return new PaymentService(paymentRepository).getPayment();
        } else
            return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "users/user")
    public String getUser(@RequestParam(value = "name") String name) {
        return new UserService(userRepository).findUser(name);
    }


}

