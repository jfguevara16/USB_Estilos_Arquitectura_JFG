package com.example.monolithic.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.monolithic.modelo.Producto;
import com.example.monolithic.repository.ProductoRepository;

@Service
public class ProductoServicio {
	
	    @Autowired
	    private ProductoRepository productoRepository;

	    public List<Producto> getAllProductos() {
	        return productoRepository.findAll();
	    }

	    public Producto getProductoById(Long id) {
	        return productoRepository.findById(id).orElse(null);
	    }

	    public Producto saveProducto(Producto producto) {
	        return productoRepository.save(producto);
	    }

	    public void deleteProducto(Long id) {
	        productoRepository.deleteById(id);
	    }

}
