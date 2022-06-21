package com.simpleapp.orderservice.controllers;


import com.simpleapp.orderservice.entities.Order;
import com.simpleapp.orderservice.services.MainService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/test")
    public String test() {return "order successful";}

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return mainService.getOrders();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> getOrderById(@PathVariable UUID id){

        return mainService.getOrderById(id);
    }

    @PostMapping("/save/order")
    public String saveOrder(@RequestBody Order order){
        mainService.saveOrder(order);
        return "order saved";
    }

}
