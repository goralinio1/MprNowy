package com.example.Model;

import ch.qos.logback.core.model.Model;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Model> models;
}
