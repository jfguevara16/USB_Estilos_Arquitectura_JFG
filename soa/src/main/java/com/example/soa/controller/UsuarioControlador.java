package com.example.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.soa.modelo.Usuario;
import com.example.soa.servicio.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
	
	    @Autowired
	    private UsuarioService userService;

	    @GetMapping
	    public List<Usuario> getAllUsers() {
	        return userService.getAllUsers();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
	        return userService.getUserById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Usuario createUser(@RequestBody Usuario usuario) {
	        return userService.saveUser(usuario);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	        return ResponseEntity.noContent().build();
	    }

}
