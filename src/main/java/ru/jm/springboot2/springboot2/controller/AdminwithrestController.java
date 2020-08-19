package ru.jm.springboot2.springboot2.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.jm.springboot2.springboot2.dto.UserDeleteDto;
import ru.jm.springboot2.springboot2.dto.UserDto;
import ru.jm.springboot2.springboot2.model.Role;
import ru.jm.springboot2.springboot2.model.User;
import ru.jm.springboot2.springboot2.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class AdminwithrestController {
    @Autowired
    private UserService userService;

    @PostMapping("/admin/add_user")
    public void addUser(@RequestBody UserDto userDto) {

        userService.addUser(userDto.toUser());
//        userService.addUser(buildUser(objectNodeUser));
    }

    @GetMapping("/admin/get_users")
    public ResponseEntity<Object> getUsersInfo() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/admin/edit_user")
    public ResponseEntity<User> editUser(@RequestBody UserDto user) {
        User updateUser = user.toUser();
        updateUser.setId(user.getId());
        userService.addUser(updateUser);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete_user{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        System.out.println(id);
        userService.removeUser(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }



}
