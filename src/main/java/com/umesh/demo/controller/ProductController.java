package com.umesh.demo.controller;

import com.umesh.demo.entity.Product;
import com.umesh.demo.repository.ProductDao;
import com.umesh.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
@EnableCaching
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "Product")
    public Product findProduct(@PathVariable int id) {
        return productService.findProductById(id);
    }

    @GetMapping("/byName/{name}")
    public Product findProductByName(@PathVariable String name){
        System.out.println("Controller");
        System.out.println("name: "+name);
        return productService.findProductByName(name);
    }

    @GetMapping("/byQuantity/{quantity}")
    public Product findProductByQuantity(@PathVariable int quantity){
        System.out.println("Controller");
        System.out.println("quantity: "+quantity);
        return productService.findProductByQuantity(quantity);
    }


    @PutMapping
    @CachePut(value = "Product",key = "#product.id")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "Product", allEntries=true)
    public String remove(@PathVariable int id)   {
        return productService.deleteProduct(id);
    }
}