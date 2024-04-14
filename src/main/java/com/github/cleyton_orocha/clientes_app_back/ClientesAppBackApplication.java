package com.github.cleyton_orocha.clientes_app_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.cleyton_orocha.clientes_app_back.model.entity.Cliente;
import com.github.cleyton_orocha.clientes_app_back.model.repository.ClienteRepository;

@SpringBootApplication
public class ClientesAppBackApplication {

	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository){
		return args -> {
			clienteRepository.save(Cliente.builder().name("Cleyton").CPF("00000000000").build());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientesAppBackApplication.class, args);
	}

}
