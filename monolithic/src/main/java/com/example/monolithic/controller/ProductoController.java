package com.example.monolithic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.monolithic.modelo.Producto;
import com.example.monolithic.servicio.ProductoServicio;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	 @Autowired
	    private ProductoServicio productoService;

	    @GetMapping
	    public List<Producto> getAllProductos() {
	        return productoService.getAllProductos();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
	        Producto producto = productoService.getProductoById(id);
	        if (producto != null) {
	            return new ResponseEntity<>(producto, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public Producto createProducto(@RequestBody Producto producto) {
	        return productoService.saveProducto(producto);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
	        Producto producto = productoService.getProductoById(id);
	        if (producto != null) {
	            producto.setNombre(productoDetails.getNombre());
	            producto.setPrecio(productoDetails.getPrecio());
	            return new ResponseEntity<>(productoService.saveProducto(producto), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> deleteProducto(@PathVariable Long id) {
	        productoService.deleteProducto(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

}
