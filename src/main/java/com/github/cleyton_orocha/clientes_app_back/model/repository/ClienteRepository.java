package com.github.cleyton_orocha.clientes_app_back.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cleyton_orocha.clientes_app_back.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
