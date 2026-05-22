package ar.edu.unpaz.rotiseria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unpaz.rotiseria.model.Cliente;
import ar.edu.unpaz.rotiseria.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Cliente guardar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}

