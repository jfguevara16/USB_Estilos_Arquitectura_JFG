package com.example.soa.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soa.modelo.Usuario;
import com.example.soa.repositorio.UsuarioRepository;

@Service
public class UsuarioService {
	
	    @Autowired
	    private UsuarioRepository userRepository;

	    public List<Usuario> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public Optional<Usuario> getUserById(Long id) {
	        return userRepository.findById(id);
	    }

	    public Usuario saveUser(Usuario usuario) {
	        return userRepository.save(usuario);
	    }

	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }

}
