package com.simpleapp.orderservice.repositories;

import com.simpleapp.orderservice.entities.Order;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<Order, UUID> {

}
