package com.example.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id @GeneratedValue
    private Long id;
    private String name;
    private String category;
    private double price;

}
