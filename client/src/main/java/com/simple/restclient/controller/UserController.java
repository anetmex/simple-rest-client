package com.simple.restclient.controller;

import com.simple.restclient.domain.User;
import com.simple.restclient.repository.UserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return userRepository.selectAll();
    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userRepository.select(id);
    }

    @PostMapping(path = "/create")
    public String createUser(@RequestBody User user) {
        if (userRepository.select(user.getId()) != null) {
            return "User already exists!";
        }
        userRepository.create(user);
        return "User has been created";
    }

    @PutMapping(path = "/update")
    public String updateUser(@RequestBody User user) {
        if (userRepository.select(user.getId()) == null) {
            return "User is NOT found!";
        }
        userRepository.update(user);
        return "User has been updated";
    }

    @DeleteMapping(path = "/{id}/delete")
    public String deleteUser(@PathVariable("id") Integer id) {
        if (userRepository.delete(id)) {
            return "User by id [ " + id + " ] has been deleted successfully";
        }
        return "User by id [ " + id + " ] is not found!";
    }
}
