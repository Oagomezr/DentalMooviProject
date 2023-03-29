package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCart;

    @Column(nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn (name = "id_users")
    private Users idUser;

    @ManyToOne
    @JoinColumn (name = "id_product")
    private Products idProduct;
}
