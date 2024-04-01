package com.bilgeadam.WHITEGOODS.controller;

import com.bilgeadam.WHITEGOODS.DTO.OrderDTO;
import com.bilgeadam.WHITEGOODS.entity.Order;
import com.bilgeadam.WHITEGOODS.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String isRunning() {
        return "API is working";
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrderByID(@PathVariable("id") Integer id) {
        return orderService.getOrderByID(id);
    }

    @PostMapping(path ="/add" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Order saveOrder(@RequestBody OrderDTO dto) {return orderService.saveOrder(dto);}

    @PutMapping(path ="/update" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody OrderDTO dto) throws Exception {
        return orderService.updateOrder(dto);
    }
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteOrder(@PathVariable("id") Integer id) throws Exception {
        orderService.deleteOrder(id);
        return "Silme İşlemi Başarılı.";
    }
}

