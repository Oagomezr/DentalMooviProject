package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Actions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAction;
    
    @Column(nullable = false)
    private String name;
}