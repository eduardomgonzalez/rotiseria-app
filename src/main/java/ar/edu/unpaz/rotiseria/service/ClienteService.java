package ar.edu.unpaz.rotiseria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unpaz.rotiseria.model.Cliente;
import ar.edu.unpaz.rotiseria.repository.ClienteRepository;

/**
 * Servicio de aplicacion para operaciones de clientes.
 *
 * Centraliza el acceso al repositorio para que los controladores no trabajen
 * directamente con JPA.
 */
@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	/**
	 * Crea el servicio con el repositorio de clientes requerido.
	 *
	 * @param clienteRepository repositorio JPA de clientes
	 */
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	/**
	 * Obtiene todos los clientes persistidos.
	 *
	 * @return lista completa de clientes
	 */
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	/**
	 * Guarda un cliente nuevo o actualiza uno existente si ya tiene id.
	 *
	 * @param cliente cliente a persistir
	 * @return cliente persistido
	 */
	public Cliente guardar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}

