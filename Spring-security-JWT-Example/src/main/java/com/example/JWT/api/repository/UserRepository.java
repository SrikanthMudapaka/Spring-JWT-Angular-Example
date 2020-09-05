package com.example.JWT.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JWT.api.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByName(String name);

}
