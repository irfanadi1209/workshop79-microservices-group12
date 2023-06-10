package com.example.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    private static final String MESSAGE = "Order not found";

    public Order createOrder(OrderRequest orderRequest) {
        Order newOrder = Order.builder()
                .totalPrice(0)
                .totalQuantity(orderRequest.getTotalQuantity())
                .orderItemList(orderRequest.getOrderItemList())
                .build();

        return orderRepository.save(newOrder);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrder(String id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            return order.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MESSAGE);
        }
    }

    public Order updateOrder(String id, OrderRequest orderRequest) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            Order updatedOrder = order.get();

            updatedOrder.setTotalQuantity(orderRequest.getTotalQuantity());
            updatedOrder.setTotalPrice(0);
            updatedOrder.setOrderItemList(orderRequest.getOrderItemList());

            return orderRepository.save(updatedOrder);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MESSAGE);
        }
    }

    public String deleteOrder(String id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            orderRepository.deleteById(id);
            return "Order deleted";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MESSAGE);
        }
    }
}
