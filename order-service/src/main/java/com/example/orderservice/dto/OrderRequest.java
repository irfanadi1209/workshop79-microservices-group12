package com.example.orderservice.dto;

import java.util.List;

import com.example.orderservice.model.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderRequest {
    private Integer totalQuantity;
    private List<OrderItem> orderItemList;
}
