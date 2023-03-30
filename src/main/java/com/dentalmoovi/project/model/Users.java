package com.dentalmoovi.project.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Users {

    public Users(String firstName, String lastName, String password, String celPhone, String city, Roles idRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.celPhone = celPhone;
        this.city = city;
        this.idRole=idRole;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false, unique = true)
    private String celPhone;

    @Column(nullable = false)
    private String city;

    @Column(nullable = true)
    private LocalDate birthDate;
    @Column(nullable = true)
    private String address;
    @Column(nullable = true)
    private String apartament;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Roles idRole;
}
