package com.simpleapp.orderservice.services;


import com.simpleapp.orderservice.entities.Order;
import com.simpleapp.orderservice.repositories.MainRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    private MainRepository mainRepo;

    public List<Order> getOrders(){
        return mainRepo.findAll();
    }

    public Optional<Order> getOrderById(UUID id){
        return mainRepo.findById(id);
    }

    public void saveOrder(Order order) {
        mainRepo.save(order);
    }
    public Optional<Order> getOrderByIdCrossModule(UUID id) {
        return mainRepo.findById(id);
    }
}
