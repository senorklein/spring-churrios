package com.churrios.api.controllers;

import com.churrios.api.entities.User;
import com.churrios.api.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") String id, Model model) {
        logger.error("id " + id.toString());
        User user = userRepository.findByUUID(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id"));
        model.addAttribute("user", user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<User> adduser(@RequestBody User user) {
       logger.error("user " + user.toString(), user);
       logger.error("user: " + user.name);
       userRepository.save(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
