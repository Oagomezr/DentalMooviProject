package com.dentalmoovi.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "modules")
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;
    
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn (name = "id_action")
    private Actions idAction;
}
