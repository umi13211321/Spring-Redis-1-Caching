package com.umesh.demo.service;

import com.umesh.demo.entity.Product;

import java.util.List;

public interface ProductService {
    public Product save(Product product);

    public List<Product> findAll();

    public Product findProductById(int id);

    public String deleteProduct(int id);

    public Product updateProduct(Product product);

    public Product findProductByName(String name);

    public Product findProductByQuantity(int quantity);
}
