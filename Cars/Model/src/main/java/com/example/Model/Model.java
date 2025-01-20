package com.example.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer year;
    private String bodyType;
    private String fuelType;
    private Integer enginePower;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
