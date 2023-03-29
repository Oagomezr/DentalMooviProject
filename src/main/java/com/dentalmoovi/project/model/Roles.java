package com.dentalmoovi.project.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    
    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "role_employee",
                joinColumns = {@JoinColumn(name = "id_role")},
                inverseJoinColumns = {@JoinColumn(name = "id_action")})
    private List<Actions> idAction = new ArrayList<>();
}
