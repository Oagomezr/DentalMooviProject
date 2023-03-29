package com.dentalmoovi.project.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @ManyToOne
    @JoinColumn (name = "id_user")
    private Users idUser;

    @ManyToOne
    @JoinColumn (name = "id_payment_method")
    private PaymentMethod idPaymentMethod;

    @ManyToOne
    @JoinColumn (name = "id_domicile")
    private Domiciles idDomicile;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private LocalDate orderDate;

    @Column(nullable = false)
    private LocalDate deliveryDate;
}
