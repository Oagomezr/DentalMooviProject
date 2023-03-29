package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.project.model.Cart;

public interface ICartRep extends JpaRepository<Cart,Long>{
    
}
