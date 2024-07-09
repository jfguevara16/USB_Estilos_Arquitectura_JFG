package com.example.microservicio.producto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.microservicio.producto.data.Producto;

@Service
public class ProductoService {
    
	private List<Producto> productos = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public List<Producto> getAllProducts() {
        return productos;
    }

    public Producto createProducts(Producto producto) {
    	producto.setId(counter.incrementAndGet());
    	productos.add(producto);
        return producto;
    }
}
