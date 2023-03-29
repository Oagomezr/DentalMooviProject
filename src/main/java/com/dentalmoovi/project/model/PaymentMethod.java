package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaymentMethod;

    @Column(nullable = false)
    private String name;
}
