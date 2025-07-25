package com.example.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role; // "CUSTOMER" or "ADMIN"

}
