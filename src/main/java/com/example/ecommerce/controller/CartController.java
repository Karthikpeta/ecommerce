package com.example.ecommerce.controller;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.CartItemRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        Product product = productRepo.findById(item.getProduct().getId()).orElseThrow();
        item.setProduct(product);
        return cartRepo.save(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartRepo.findByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void removeItem(@PathVariable Long id) {
        cartRepo.deleteById(id);
    }
}
