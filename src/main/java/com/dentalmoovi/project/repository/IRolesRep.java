package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.project.model.Roles;

public interface IRolesRep extends JpaRepository<Roles,Long>{
    
}
