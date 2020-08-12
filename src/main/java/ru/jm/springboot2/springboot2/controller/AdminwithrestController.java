package ru.jm.springboot2.springboot2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.jm.springboot2.springboot2.Repository.UserRepository;
import ru.jm.springboot2.springboot2.model.User;
import ru.jm.springboot2.springboot2.service.UserService;

@RestController
public class AdminwithrestController {
    @Autowired
    private UserService userService;

    @PostMapping("/admin/add_user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);

    }

}
