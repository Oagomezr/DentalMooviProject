package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.project.model.Domiciles;

public interface IDomicilesRep extends JpaRepository<Domiciles,Long>{
    
}
