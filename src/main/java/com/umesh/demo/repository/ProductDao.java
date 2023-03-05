package com.umesh.demo.repository;

import com.umesh.demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductDao{

    Product save(Product product);

    List<Product> findAll();

    Product findProductById(int id);

    String deleteProduct(int id);

    Product updateProduct(Product product);

    public Product findProductByName(String name);

    public Product findProductByQuantity(int quantity);
}
