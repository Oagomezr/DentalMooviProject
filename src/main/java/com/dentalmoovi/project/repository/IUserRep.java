package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dentalmoovi.project.model.Users;

@Repository
public interface IUserRep extends JpaRepository<Users,Long>{
    
}
