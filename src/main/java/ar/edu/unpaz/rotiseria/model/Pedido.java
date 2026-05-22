package ar.edu.unpaz.rotiseria.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Cliente cliente;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemPedido> items = new ArrayList<>();

	@Enumerated(EnumType.STRING)
	private EstadoPedido estado = EstadoPedido.CREADO;

	protected Pedido() {
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public void agregarItem(Producto producto, int cantidad) {
		items.add(new ItemPedido(producto, cantidad));
	}

	public double calcularSubtotal() {
		return items.stream()
				.mapToDouble(ItemPedido::calcularImporte)
				.sum();
	}
}

