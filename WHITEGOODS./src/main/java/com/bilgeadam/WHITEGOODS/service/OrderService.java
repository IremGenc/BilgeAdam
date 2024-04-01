package com.bilgeadam.WHITEGOODS.service;

import com.bilgeadam.WHITEGOODS.DTO.OrderDTO;
import com.bilgeadam.WHITEGOODS.entity.Order;
import com.bilgeadam.WHITEGOODS.repository.OrderRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderByID(Integer id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.isEmpty() ? null : optionalOrder.get();
    }

    public Order saveOrder(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getQuantity());
        return orderRepository.save(order);
    }

    public Order updateOrder(OrderDTO dto) {
        Optional<Order> optionalOrder = orderRepository.findById(dto.getQuantity());
        if (optionalOrder.isEmpty()) return null;
        Order order = optionalOrder.get();
        order.setId(dto.getQuantity());
        return orderRepository.save(order);
    }
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}




