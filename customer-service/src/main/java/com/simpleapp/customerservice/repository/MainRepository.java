package com.simpleapp.customerservice.repository;

import com.simpleapp.customerservice.entities.Customer;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MainRepository extends JpaRepository<Customer, UUID> {
    @Query("select customer from Customer customer ")
    public Set<Customer> getCustomerSet();
}
