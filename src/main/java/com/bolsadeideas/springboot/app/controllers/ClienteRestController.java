package com.bolsadeideas.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping(value = "/listar")
	@Secured("ROLE_ADMIN")
	public List<Cliente> listar() {
		return this.clienteService.findAll();
	}

	@GetMapping(value = "/test")
	public String message() {
		return "Spring Boot Rest Api";
	}
}
