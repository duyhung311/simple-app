package com.simpleapp.productservice.services;

import com.simpleapp.productservice.dtos.Product;
import com.simpleapp.productservice.repositories.MainRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    private MainRepository mainRepo;

    public List<Product> getAllProducts() {
        return mainRepo.findAll();
    }

    public Optional<Product> getByProductById(UUID uuid){
        return mainRepo.findById(uuid);
    }

    public void saveProduct(Product product){
        mainRepo.save(product);
    }
}
