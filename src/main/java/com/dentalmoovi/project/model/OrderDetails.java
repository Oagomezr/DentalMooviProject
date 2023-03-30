package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class OrderDetails {

    public OrderDetails(int amount, double price, Orders idOrders, Products idProduct) {
        this.amount = amount;
        this.price = price;
        this.idOrders = idOrders;
        this.idProduct = idProduct;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetails;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn (name = "id_order")
    private Orders idOrders;


    @ManyToOne
    @JoinColumn (name = "id_product")
    private Products idProduct;
}
