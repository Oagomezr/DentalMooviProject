package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Domiciles {

    public Domiciles(String address, String phone, String departament, String city, Users idUser) {
        this.address = address;
        this.phone = phone;
        this.departament = departament;
        this.city = city;
        this.idUser = idUser;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDomicile;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String departament;

    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn
    private Users idUser;
}
