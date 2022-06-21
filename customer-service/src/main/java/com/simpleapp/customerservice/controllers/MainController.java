package com.simpleapp.customerservice.controllers;


import com.simpleapp.customerservice.dtos.OrderDTO;
import com.simpleapp.customerservice.entities.Customer;
import com.simpleapp.customerservice.services.MainService;
import com.simpleapp.customerservice.services.OrderServiceProxy;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private MainService customerService;

    @Autowired
    private OrderServiceProxy orderServiceProxy;
    @GetMapping("/getCustomer")
    public List<Customer> getAll(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/getCustomer/{uuid}")
    public Optional<Customer> getCustomerById(@PathVariable UUID uuid){
        return customerService.getCustomerById(uuid);
    }

    @GetMapping("/getCustomerSet")
    public Set<Customer> getAllSet(){
        return customerService.getAllCustomerSet();
    }

    @PostMapping("/save/customer")
    public String saveCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        customerService.saveCustomer(customer);
        return "success";
    }

    @GetMapping("order/crossModule/singleOrder")
    public ResponseEntity<OrderDTO> getOrder(@RequestParam UUID id){
        return orderServiceProxy.getOrder(id);
    }
}
