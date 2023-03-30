package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "modules")
public class Modules {

    public Modules(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;
    
    @Column(nullable = false)
    private String name;
}
