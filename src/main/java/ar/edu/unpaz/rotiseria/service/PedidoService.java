package ar.edu.unpaz.rotiseria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unpaz.rotiseria.model.Pedido;
import ar.edu.unpaz.rotiseria.repository.PedidoRepository;
import ar.edu.unpaz.rotiseria.strategy.DescuentoStrategy;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	private final DescuentoStrategy descuentoStrategy;

	public PedidoService(PedidoRepository pedidoRepository, DescuentoStrategy descuentoStrategy) {
		this.pedidoRepository = pedidoRepository;
		this.descuentoStrategy = descuentoStrategy;
	}

	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}

	public Pedido guardar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public double calcularTotal(Pedido pedido) {
		return descuentoStrategy.aplicar(pedido.calcularSubtotal());
	}
}

