package com.dentalmoovi.project.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "firstname", length = 20, nullable = false)
    private String firstName;

    @Column(name = "lastname", length = 20, nullable = false)
    private String lastName;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "phone", length = 10, nullable = false, unique = true)
    private int celPhone;

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
