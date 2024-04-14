package com.github.cleyton_orocha.clientes_app_back.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.github.cleyton_orocha.clientes_app_back.rest.exception.ApiErros;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleValidationErros(MethodArgumentNotValidException ex) {
        List<String> messages = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .toList();
        return new ApiErros(messages);
    }

    public ResponseEntity<ApiErros> handlerResponseStatusException(ResponseStatusException ex) {
        String messageError = ex.getMessage();
        HttpStatusCode codStatus = ex.getStatusCode();
        ApiErros apiErros = new ApiErros(Arrays.asList(messageError));
        return new ResponseEntity<ApiErros>(apiErros, codStatus);
    }
}
