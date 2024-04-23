package com.github.cleyton_orocha.clientes_app_back.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.cleyton_orocha.clientes_app_back.model.entity.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

    @Query("select s from ServicoPrestado s join s.cliente c " +
            "where upper(c.nome) like upper(:nome) " +
            "and MOUTH(s.data) = :mes")
    List<ServicoPrestado> findByNomeClienteEMes(@Param("nome") String nome, @Param("mes") Integer mes);

}
