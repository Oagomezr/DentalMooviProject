package com.dentalmoovi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmoovi.project.model.Users;

public interface IUserRep extends JpaRepository<Users,Long>{
}
