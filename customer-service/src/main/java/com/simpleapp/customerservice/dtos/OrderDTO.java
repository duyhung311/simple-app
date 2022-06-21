package com.simpleapp.customerservice.dtos;

import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderDTO implements Serializable {
    private UUID id;
}
