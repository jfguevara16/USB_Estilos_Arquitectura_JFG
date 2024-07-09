package com.example.microservicio.producto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio.producto.data.Producto;
import com.example.microservicio.producto.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping
    public List<Producto> getAllOrders() {
        return productoService.getAllProducts();
    }

    @PostMapping
    public Producto createOrder(@RequestBody Producto producto) {
        return productoService.createProducts(producto);
    }
}