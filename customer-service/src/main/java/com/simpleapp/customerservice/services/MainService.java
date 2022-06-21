package com.simpleapp.customerservice.services;

import com.simpleapp.customerservice.dtos.OrderDTO;
import com.simpleapp.customerservice.entities.Customer;
import com.simpleapp.customerservice.repository.MainRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    private MainRepository customerRepo;
    @Autowired
    private OrderServiceProxy orderServiceProxy;

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(UUID uuid) { return customerRepo.findById(uuid); }

    public Set<Customer>  getAllCustomerSet(){ return customerRepo.getCustomerSet(); }
    public void saveCustomer(Customer customer){
        customerRepo.save(customer);
    }

    public ResponseEntity<OrderDTO> getOrder(UUID uuid){
        return orderServiceProxy.getOrder(uuid);
    }
}
