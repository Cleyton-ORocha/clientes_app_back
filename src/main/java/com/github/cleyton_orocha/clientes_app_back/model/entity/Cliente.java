package com.github.cleyton_orocha.clientes_app_back.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 11)
    private String CPF;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @PrePersist
    private void persistData(){
        setDataCadastro(LocalDate.now());
    }
    
}
