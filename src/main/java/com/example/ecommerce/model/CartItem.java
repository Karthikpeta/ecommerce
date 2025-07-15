package com.example.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
	@Id @GeneratedValue
    private Long id;
    private Long userId;
    @ManyToOne
    private Product product;
    private int quantity;

}
