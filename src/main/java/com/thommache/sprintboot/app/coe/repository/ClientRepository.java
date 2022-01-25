package com.thommache.sprintboot.app.coe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thommache.sprintboot.app.coe.entity.Cliente;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Integer>{

}
