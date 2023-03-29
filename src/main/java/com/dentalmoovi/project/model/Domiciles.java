package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Domiciles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDomicile;

    @ManyToOne
    @JoinColumn (name = "id_user")
    private Users idUser;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String departament;

    @Column(nullable = false)
    private String municipality;

    @Column(nullable = false)
    private String city;
}
