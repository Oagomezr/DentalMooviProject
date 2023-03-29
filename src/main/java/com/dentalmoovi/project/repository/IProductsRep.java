package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.project.model.Products;

public interface IProductsRep extends JpaRepository<Products,Long>{
    
}
