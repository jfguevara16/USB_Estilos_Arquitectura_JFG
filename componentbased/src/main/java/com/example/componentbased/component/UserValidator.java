package com.example.componentbased.component;

import org.springframework.stereotype.Component;

import com.example.componentbased.modelo.Usuario;

@Component
public class UserValidator {
	
	public void validate(Usuario usuario) {
        // Lógica de validación
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (usuario.getCorreo() == null || usuario.getCorreo().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico es obligatorio");
        }
    }

}
