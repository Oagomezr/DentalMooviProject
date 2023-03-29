package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.project.model.PaymentMethod;

public interface IPaymentMethodRep extends JpaRepository<PaymentMethod,Long>{
    
}
