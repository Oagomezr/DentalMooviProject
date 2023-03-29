package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.project.model.OrderDetails;

public interface IOrderDetailsRep extends JpaRepository<OrderDetails,Long>{
    
}
