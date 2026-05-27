package ar.edu.unpaz.rotiseria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unpaz.rotiseria.model.Pedido;
import ar.edu.unpaz.rotiseria.service.PedidoService;

/**
 * Controlador REST para consultar pedidos.
 *
 * Actualmente expone la consulta de pedidos y deja la logica de acceso a
 * datos en {@link PedidoService}.
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService pedidoService;

	/**
	 * Crea el controlador con el servicio de pedidos requerido.
	 *
	 * @param pedidoService servicio que resuelve operaciones sobre pedidos
	 */
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	/**
	 * Lista todos los pedidos registrados en el sistema.
	 *
	 * @return pedidos persistidos
	 */
	@GetMapping
	public List<Pedido> listar() {
		return pedidoService.listar();
	}
}

