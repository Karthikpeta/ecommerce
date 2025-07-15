package com.example.ecommerce.controller;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.repository.CartItemRepository;
import com.example.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CartItemRepository cartRepo;

    @PostMapping("/{userId}")
    public Order placeOrder(@PathVariable Long userId) {
        List<CartItem> cart = cartRepo.findByUserId(userId);
        double total = cart.stream().mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity()).sum();
        cartRepo.deleteByUserId(userId);
        return orderRepo.save(new Order(null, userId, total, "PLACED"));
    }

    @GetMapping("/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {
        return orderRepo.findByUserId(userId);
    }
}
