package ar.edu.unpaz.rotiseria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unpaz.rotiseria.model.Cliente;
import ar.edu.unpaz.rotiseria.service.ClienteService;

/**
 * Controlador REST para administrar clientes de la rotiseria.
 *
 * Expone operaciones HTTP relacionadas con clientes y delega la logica de
 * negocio en {@link ClienteService}.
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	/**
	 * Crea el controlador con el servicio de clientes requerido.
	 *
	 * @param clienteService servicio que resuelve las operaciones de clientes
	 */
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	/**
	 * Lista todos los clientes registrados.
	 *
	 * @return lista completa de clientes guardados
	 */
	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listar();
	}

	/**
	 * Crea un nuevo cliente a partir del cuerpo JSON recibido.
	 *
	 * @param cliente datos del cliente enviados por el cliente HTTP
	 * @return cliente guardado con su identificador generado
	 */
	@PostMapping
	public Cliente crear(@RequestBody Cliente cliente) {
		return clienteService.guardar(cliente);
	}
}

