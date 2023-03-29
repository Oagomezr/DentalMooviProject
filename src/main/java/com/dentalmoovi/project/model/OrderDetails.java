package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetails;

    @ManyToOne
    @JoinColumn (name = "id_order")
    private Order idOrders;

    @ManyToOne
    @JoinColumn (name = "id_product")
    private Products idProduct;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private double price;
}
