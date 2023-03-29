package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.project.model.Actions;

public interface IActionsRep extends JpaRepository<Actions,Long>{
    
}
