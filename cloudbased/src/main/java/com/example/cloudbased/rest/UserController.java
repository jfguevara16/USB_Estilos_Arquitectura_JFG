package com.example.cloudbased.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloudbased.entity.Usuario;
import com.example.cloudbased.exception.ResourceNotFoundException;
import com.example.cloudbased.repository.UserRepository;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
	
	@Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public Usuario createUser(@RequestBody Usuario user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Usuario getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

}
