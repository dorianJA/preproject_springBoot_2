package ru.jm.springboot2.springboot2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jm.springboot2.springboot2.Repository.UserRepository;
import ru.jm.springboot2.springboot2.model.Role;
import ru.jm.springboot2.springboot2.model.User;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public void addUser(User user) {
        user.setRoles(Collections.singleton(new Role(1L,"USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

}
