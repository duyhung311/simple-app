package com.simpleapp.customerservice.services;

import com.simpleapp.customerservice.dtos.OrderDTO;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Service
@FeignClient(name = "order-service")
public interface OrderServiceProxy {
    @RequestMapping("order/crossModule/singleOrder")
    public ResponseEntity<OrderDTO> getOrder(@RequestParam UUID id);
}