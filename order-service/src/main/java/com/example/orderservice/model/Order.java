package com.example.orderservice.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class Order {
    @Id
    private String id;
    private Integer totalQuantity;
    private Integer totalPrice;
    private List<OrderItem> orderItemList;
}
