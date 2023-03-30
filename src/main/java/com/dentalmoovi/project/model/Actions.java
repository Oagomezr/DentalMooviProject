package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Actions {

    public Actions(char name, Modules idModule) {
        this.name = name;
        this.idModule = idModule;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAction;
    
    @Column(nullable = false)
    private char name;

    @ManyToOne
    @JoinColumn
    private Modules idModule;
}