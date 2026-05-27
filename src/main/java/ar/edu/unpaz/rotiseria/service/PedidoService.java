package ar.edu.unpaz.rotiseria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unpaz.rotiseria.model.Pedido;
import ar.edu.unpaz.rotiseria.repository.PedidoRepository;
import ar.edu.unpaz.rotiseria.strategy.DescuentoStrategy;

/**
 * Servicio de aplicacion para operaciones de pedidos.
 *
 * Ademas de persistir pedidos, aplica la estrategia de descuento configurada
 * para calcular totales sin acoplar el pedido a una regla concreta.
 */
@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	private final DescuentoStrategy descuentoStrategy;

	/**
	 * Crea el servicio con sus dependencias.
	 *
	 * @param pedidoRepository repositorio JPA de pedidos
	 * @param descuentoStrategy regla de descuento activa para calcular totales
	 */
	public PedidoService(PedidoRepository pedidoRepository, DescuentoStrategy descuentoStrategy) {
		this.pedidoRepository = pedidoRepository;
		this.descuentoStrategy = descuentoStrategy;
	}

	/**
	 * Obtiene todos los pedidos registrados.
	 *
	 * @return lista completa de pedidos
	 */
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}

	/**
	 * Guarda un pedido nuevo o actualiza uno existente si ya tiene id.
	 *
	 * @param pedido pedido a persistir
	 * @return pedido persistido
	 */
	public Pedido guardar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	/**
	 * Calcula el total final de un pedido aplicando la estrategia de descuento.
	 *
	 * @param pedido pedido sobre el que se calcula el total
	 * @return total final luego de aplicar la estrategia de descuento
	 */
	public double calcularTotal(Pedido pedido) {
		return descuentoStrategy.aplicar(pedido.calcularSubtotal());
	}
}

