package ru.jm.springboot2.springboot2.service;

import ru.jm.springboot2.springboot2.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String name);
}
