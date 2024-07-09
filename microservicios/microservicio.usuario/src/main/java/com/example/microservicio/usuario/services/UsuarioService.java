package com.example.microservicio.usuario.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.microservicio.usuario.data.Usuario;

@Service
public class UsuarioService {
	
	private List<Usuario> users = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public List<Usuario> getAllUsers() {
        return users;
    }

    public Usuario createUser(Usuario user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
        return user;
    }

}
