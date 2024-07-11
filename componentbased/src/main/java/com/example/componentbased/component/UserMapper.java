package com.example.componentbased.component;

import org.springframework.stereotype.Component;

import com.example.componentbased.modelo.Usuario;

@Component
public class UserMapper {
	
	public Usuario toDto(Usuario user) {
		Usuario dto = new Usuario();
        dto.setId(user.getId());
        dto.setNombre(user.getNombre());
        dto.setCorreo(user.getCorreo());
        return dto;
    }

    public Usuario toEntity(Usuario dto) {
    	Usuario user = new Usuario();
        user.setId(dto.getId());
        user.setNombre(dto.getNombre());
        user.setCorreo(dto.getCorreo());
        return user;
    }

}
