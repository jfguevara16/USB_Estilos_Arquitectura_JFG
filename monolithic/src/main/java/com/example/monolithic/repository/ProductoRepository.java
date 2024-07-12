package com.example.monolithic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.monolithic.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
