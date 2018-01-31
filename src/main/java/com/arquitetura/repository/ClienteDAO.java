package com.arquitetura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arquitetura.model.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

}
