package com.umesh.demo.service;

import com.umesh.demo.entity.Product;
import com.umesh.demo.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findProductById(int id) {
        return productDao.findProductById(id);
    }

    @Override
    public String deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public Product findProductByName(String name) {
        System.out.println("**********Service");
        return productDao.findProductByName(name);
    }

    @Override
    public Product findProductByQuantity(int quantity) {
        return productDao.findProductByQuantity(quantity);
    }
}
