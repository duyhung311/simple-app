package com.simpleapp.productservice.repositories;

import com.simpleapp.productservice.dtos.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<Product, UUID> {

}
