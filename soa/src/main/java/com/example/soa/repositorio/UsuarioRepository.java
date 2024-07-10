package com.example.soa.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.soa.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
