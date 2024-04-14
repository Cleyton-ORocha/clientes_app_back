package com.github.cleyton_orocha.clientes_app_back.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.cleyton_orocha.clientes_app_back.model.entity.Cliente;
import com.github.cleyton_orocha.clientes_app_back.model.repository.ClienteRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
@RequestMapping("api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody @Valid Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente findById(@PathVariable Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteById(@PathVariable Integer id) {
        clienteRepository.findById(id)
                .map(m -> {
                    clienteRepository.delete(m);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cliente putMethodName(@RequestBody @Valid Cliente cliente) {
        return clienteRepository.findById(cliente.getId())
                .map(m -> {
                    cliente.setId(m.getId());
                    return clienteRepository.save(cliente);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
    }

}
