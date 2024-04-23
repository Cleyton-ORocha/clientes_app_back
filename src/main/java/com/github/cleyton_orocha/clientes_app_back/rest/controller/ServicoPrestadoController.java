package com.github.cleyton_orocha.clientes_app_back.rest.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.cleyton_orocha.clientes_app_back.model.entity.ServicoPrestado;
import com.github.cleyton_orocha.clientes_app_back.model.repository.ClienteRepository;
import com.github.cleyton_orocha.clientes_app_back.model.repository.ServicoPrestadoRepository;
import com.github.cleyton_orocha.clientes_app_back.rest.DTO.ServicoPrestadoDTO;
import com.github.cleyton_orocha.clientes_app_back.util.BigDecimalConverter;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/servico-prestado")
public class ServicoPrestadoController {
    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado saveServicoPrestado(@RequestBody ServicoPrestadoDTO servicoPrestadoDTO) {
        LocalDate date = LocalDate.parse(servicoPrestadoDTO.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        ServicoPrestado servicoPrestadoRequest = ServicoPrestado.builder()
                .descricao(servicoPrestadoDTO.getDescricao())
                .cliente(
                        clienteRepository
                                .findById(servicoPrestadoDTO.getIdCliente())
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                        "Error ao procurar o cliente")))
                .data(date)
                .preco(BigDecimalConverter.valueOf(servicoPrestadoDTO.getPreco()))
                .build();

        return servicoPrestadoRepository.save(servicoPrestadoRequest);
    }

    @GetMapping("path")
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes) {
        return servicoPrestadoRepository.findByNomeClienteEMes("%" + nome + "%", mes);
    }

}
