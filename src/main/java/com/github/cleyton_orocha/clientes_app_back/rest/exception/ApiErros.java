package com.github.cleyton_orocha.clientes_app_back.rest.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiErros{
    private List<String> erros;
}