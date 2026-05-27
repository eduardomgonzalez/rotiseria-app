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

/**
 * Pedido realizado por un cliente.
 *
 * Un pedido agrupa varios {@link ItemPedido}. Cada item conserva el precio
 * unitario del producto al momento de cargar el pedido, evitando que cambios
 * futuros del menu alteren pedidos ya creados.
 */
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

	/**
	 * Constructor requerido por JPA para reconstruir la entidad.
	 */
	protected Pedido() {
	}

	/**
	 * Crea un pedido nuevo asociado a un cliente.
	 *
	 * @param cliente cliente que realiza el pedido
	 */
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Obtiene el identificador tecnico generado por la base de datos.
	 *
	 * @return id del pedido
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Obtiene el cliente asociado al pedido.
	 *
	 * @return cliente que hizo el pedido
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Obtiene los renglones o items del pedido.
	 *
	 * @return lista mutable de items del pedido
	 */
	public List<ItemPedido> getItems() {
		return items;
	}

	/**
	 * Obtiene el estado actual del pedido.
	 *
	 * @return estado del pedido
	 */
	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	/**
	 * Agrega un producto al pedido con la cantidad indicada.
	 *
	 * @param producto producto solicitado
	 * @param cantidad cantidad de unidades
	 */
	public void agregarItem(Producto producto, int cantidad) {
		items.add(new ItemPedido(producto, cantidad));
	}

	/**
	 * Calcula la suma de todos los items del pedido sin aplicar descuentos.
	 *
	 * @return subtotal del pedido
	 */
	public double calcularSubtotal() {
		return items.stream()
				.mapToDouble(ItemPedido::calcularImporte)
				.sum();
	}
}

