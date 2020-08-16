package ru.jm.springboot2.springboot2.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.jm.springboot2.springboot2.Repository.UserRepository;
import ru.jm.springboot2.springboot2.model.Role;
import ru.jm.springboot2.springboot2.model.User;
import ru.jm.springboot2.springboot2.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class AdminwithrestController {
    @Autowired
    private UserService userService;

    @PostMapping("/admin/add_user")
    public void addUser(@RequestBody ObjectNode objectNodeUser) {
        userService.addUser(buildUser(objectNodeUser));
    }

    @GetMapping("/get_users")
    public ResponseEntity<Object> getUsersInfo() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/admin/update_user")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete_user")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        userService.removeUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private User buildUser(ObjectNode objectNodeUser) {
        User user = new User();
        user.setFirstName(objectNodeUser.get("firstName").textValue());
        user.setLastName(objectNodeUser.get("lastName").textValue());
        user.setEmail(objectNodeUser.get("email").textValue());
        user.setAge(objectNodeUser.get("age").textValue());
        user.setPassword(objectNodeUser.get("password").textValue());
        Role role = new Role();
        role.setId(Long.valueOf(objectNodeUser.get("roles").textValue()));
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRoles(roleSet);
        return user;
    }

}
