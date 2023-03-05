package com.umesh.demo.repository;

import com.umesh.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    public static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate template;

    @Override
    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    @Override
    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    @Override
    public Product findProductById(int id){
        System.out.println("Inside findProductById");
        System.out.println("Checkpoint: "+(Product) template.opsForHash().get(HASH_KEY,id));
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }

    @Override
    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }

    @Override
    public Product updateProduct(Product product) {
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    @Override
    public Product findProductByName(String name) {
        System.out.println("**********ProductDaoImpl");

        return (Product) template.opsForHash().get(HASH_KEY, name);
    }

    @Override
    public Product findProductByQuantity(int quantity) {
        System.out.println("**********ProductDaoImpl");
        return (Product) template.opsForHash().get(HASH_KEY, quantity);
    }
}