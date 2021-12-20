package com.hitchsavan.randommathsite.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import com.hitchsavan.randommathsite.models.Order;
import com.hitchsavan.randommathsite.models.Product;
import com.hitchsavan.randommathsite.models.Shop;
import com.hitchsavan.randommathsite.repository.OrderRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getOrders() {
        return (List<Order>) orderRepository.findAll();
    }
    
    @PostMapping
    void addOrder(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @PutMapping(path = "id")
    void updateOrder(@PathVariable("id") long id,
                     @RequestParam(required = false) Product product,
                     @RequestParam(required = false) Shop shop,
                     @RequestParam(required = false) long amount,
                     @RequestParam(required = false) String status,
                     @RequestParam(required = false) Date date) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException(
                "I'm broken, I dunno"
            ));

        if(product != null &&
            !Objects.equals(order.getProduct(), product)) {
                order.setProduct(product);
            }

        if(shop != null &&
            !Objects.equals(order.getShop(), shop)) {
                order.setShop(shop);
            }
        
        if(amount >= 0 &&
            !Objects.equals(order.getAmount(), amount)) {
                order.setAmount(amount);
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