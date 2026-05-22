package ar.edu.unpaz.rotiseria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unpaz.rotiseria.model.Cliente;
import ar.edu.unpaz.rotiseria.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listar();
	}

	@PostMapping
	public Cliente crear(@RequestBody Cliente cliente) {
		return clienteService.guardar(cliente);
	}
}

