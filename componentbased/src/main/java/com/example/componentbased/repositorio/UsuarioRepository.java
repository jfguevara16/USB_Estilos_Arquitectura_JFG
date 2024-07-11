package com.example.componentbased.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.componentbased.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
