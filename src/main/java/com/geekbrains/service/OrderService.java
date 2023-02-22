package com.geekbrains.service;

import com.geekbrains.dao.OrderRepository;
import com.geekbrains.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public List<Order> findById(Long id){
        return orderRepository.findById(id);
    }
}
