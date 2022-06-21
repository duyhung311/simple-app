package com.simpleapp.orderservice.controllers;

import com.simpleapp.orderservice.dtos.OrderDTO;
import com.simpleapp.orderservice.entities.Order;
import com.simpleapp.orderservice.services.MainService;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryServiceController {

    @Autowired
    private MainService mainService;

    @GetMapping("order/crossModule/singleOrder")
    public ResponseEntity<OrderDTO> getOrder(@RequestParam UUID id){
        System.out.println("mapping success");
        try {
            Optional<Order> order = mainService.getOrderByIdCrossModule(id);
            Order myOrder = order.get();

            OrderDTO oDto = new OrderDTO();
            oDto.setId(myOrder.getId());
            return new ResponseEntity<OrderDTO>(oDto, null, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<OrderDTO>(null, null, HttpStatus.BAD_REQUEST);
        }
    }
}
