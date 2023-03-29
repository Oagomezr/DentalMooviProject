package com.dentalmoovi.project.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column(name = "name", length = 20, nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double stock;

    @Column(nullable = false)
    private String lote;

    @Column(nullable = true)
    private String invima;

    @Column(nullable = true)
    private LocalDate expirationDate;

    
}
