package com.example.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	 @Id @GeneratedValue
	    private Long id;
	    private Long userId;
	    private double total;
	    private String status = "PLACED";

}
