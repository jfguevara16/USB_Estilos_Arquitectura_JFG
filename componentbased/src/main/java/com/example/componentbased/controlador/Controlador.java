package com.example.componentbased.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.componentbased.component.UserComponent;
import com.example.componentbased.component.UserMapper;
import com.example.componentbased.component.UserValidator;
import com.example.componentbased.modelo.Usuario;

@RestController
@RequestMapping("/usuario")
public class Controlador {
	
	@Autowired
    private UserComponent userComponent;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<Usuario> getAllUsers() {
        return userComponent.getAllUsers().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUserById(@PathVariable Long id) {
        return userComponent.getUserById(id)
                .map(userMapper::toDto);
    }

    @PostMapping
    public Usuario createUser(@RequestBody Usuario userDto) {
    	Usuario user = userMapper.toEntity(userDto);
        userValidator.validate(user);
        return userMapper.toDto(userComponent.createUser(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userComponent.deleteUser(id);
    }

}
