package com.ufabc.adm.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufabc.adm.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  
}
