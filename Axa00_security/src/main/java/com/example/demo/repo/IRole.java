package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Role;

public interface IRole extends JpaRepository<Role, Long>{

}
