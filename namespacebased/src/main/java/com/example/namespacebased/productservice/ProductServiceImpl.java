package com.example.namespacebased.productservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(String name, double price) {
    	Product producto=new Product();
    	producto.setName(name);
    	producto.setPrice(price);
        productRepository.save(producto);
    }

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

}
