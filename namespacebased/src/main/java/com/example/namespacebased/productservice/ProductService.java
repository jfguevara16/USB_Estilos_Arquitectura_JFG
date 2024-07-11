package com.example.namespacebased.productservice;

import java.util.List;

public interface  ProductService {
	
	void createProduct(String name, double price);
	
	List<Product> getAllProducts();
}
