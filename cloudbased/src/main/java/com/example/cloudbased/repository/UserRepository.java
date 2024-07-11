package com.example.cloudbased.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cloudbased.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

}
