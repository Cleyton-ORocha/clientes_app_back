package com.github.cleyton_orocha.clientes_app_back.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cleyton_orocha.clientes_app_back.model.entity.Servico;


public interface ServicoRepository extends JpaRepository<Servico, Integer>{
    
}
