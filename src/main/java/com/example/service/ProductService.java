package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public int save(Product p){
        return repository.save(p);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(int id){
        return repository.findById(id);
    }

    public int update(Product p){
        return repository.update(p);
    }

    public int delete(int id){
        return repository.delete(id);
    }

}