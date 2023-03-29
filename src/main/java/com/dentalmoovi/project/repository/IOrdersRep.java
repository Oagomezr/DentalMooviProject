package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.project.model.Orders;

public interface IOrdersRep extends JpaRepository<Orders,Long>{
    
}
