package com.dentalmoovi.project.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "orders")
public class Orders {

    public Orders(double total, LocalDate orderDate, LocalDate deliveryDate, Users idUser,
            PaymentMethod idPaymentMethod, Domiciles idDomicile) {
        this.total = total;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.idUser = idUser;
        this.idPaymentMethod = idPaymentMethod;
        this.idDomicile = idDomicile;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private LocalDate orderDate;

    @Column(nullable = false)
    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn (name = "id_user")
    private Users idUser;

    @ManyToOne
    @JoinColumn (name = "id_payment_method")
    private PaymentMethod idPaymentMethod;

    @ManyToOne
    @JoinColumn (name = "id_domicile")
    private Domiciles idDomicile;
}
