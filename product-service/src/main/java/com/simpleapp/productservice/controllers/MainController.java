package com.simpleapp.productservice.controllers;

import com.simpleapp.productservice.dtos.Product;
import com.simpleapp.productservice.services.MainService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/test")
    public String test() {return "product successful";}

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return mainService.getAllProducts();
    }

    @GetMapping("products/{id}")
    public Optional<Product> getAllProducts(UUID uuid){
        return mainService.getByProductById(uuid);
    }

    @PostMapping("save/product")
    public String saveProduct(@RequestBody Product product){
        mainService.saveProduct(product);
        return "product added";
    }
}
