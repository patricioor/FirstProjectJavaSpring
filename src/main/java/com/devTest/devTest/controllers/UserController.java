package com.devTest.devTest.controllers;

import com.devTest.devTest.entites.User;
import com.devTest.devTest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll()
    {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id)
    {
        return repository.findById(id).get();
    }

    @PostMapping
    public User insertUser(@RequestBody User user)
    {
        return repository.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user)
    {
        User userFound = repository.findById(user.getId()).get();
        userFound.setName(user.getName());
        userFound.setEmail(user.getEmail());
        userFound.setDepartment(user.getDepartment());
        return repository.saveAndFlush(userFound);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        repository.deleteById(id);
    }
}
