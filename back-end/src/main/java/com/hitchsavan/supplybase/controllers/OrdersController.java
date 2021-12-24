package com.hitchsavan.supplybase.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import com.hitchsavan.supplybase.models.Orders;
import com.hitchsavan.supplybase.models.Product;
import com.hitchsavan.supplybase.models.Shop;
import com.hitchsavan.supplybase.repository.OrdersRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    
    private final OrdersRepository ordersRepository;

    public OrdersController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @GetMapping
    public List<Orders> getOrders() {
        return (List<Orders>) ordersRepository.findAll();
    }
    
    @PostMapping
    void addOrders(@RequestBody Orders orders) {
        ordersRepository.save(orders);
    }

    @PutMapping(path = "id")
    void updateOrder(@PathVariable("id") long id,
                     @RequestParam(required = false) Product product,
                     @RequestParam(required = false) Shop shop,
                     @RequestParam(required = false) long amount,
                     @RequestParam(required = false) String status,
                     @RequestParam(required = false) Date date) {
        Orders order = ordersRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException(
                "ERROR: Order with this id not found."
            ));

        if(shop != null &&
            !Objects.equals(order.getShop(), shop)) {
                order.setShop(shop);
            }

        if(status != null &&
            !Objects.equals(order.getStatus(), status)) {
                order.setStatus(status);
            }

        if(date != null &&
            !Objects.equals(order.getDate(), date)) {
                order.setDate(date);
            }
    }
}