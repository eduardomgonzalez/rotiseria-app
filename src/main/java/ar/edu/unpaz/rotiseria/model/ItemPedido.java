package ar.edu.unpaz.rotiseria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Renglon de un pedido.
 *
 * Relaciona un {@link Producto} con una cantidad. Guarda el precio unitario
 * en el momento de crear el item para que el importe historico del pedido no
 * dependa de cambios posteriores en el producto.
 */
@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Producto producto;

	private int cantidad;
	private double precioUnitario;

	/**
	 * Constructor requerido por JPA para reconstruir la entidad.
	 */
	protected ItemPedido() {
	}

	/**
	 * Crea un item para un pedido.
	 *
	 * @param producto producto pedido
	 * @param cantidad cantidad solicitada
	 */
	public ItemPedido(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		// Se copia el precio actual para mantener estable el total del pedido.
		this.precioUnitario = producto.getPrecio();
	}

	/**
	 * Obtiene el identificador tecnico generado por la base de datos.
	 *
	 * @return id del item
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Obtiene el producto asociado al item.
	 *
	 * @return producto pedido
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * Obtiene la cantidad solicitada.
	 *
	 * @return cantidad de unidades
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Obtiene el precio unitario usado para este pedido.
	 *
	 * @return precio unitario historico
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * Calcula el importe del item.
	 *
	 * @return cantidad multiplicada por precio unitario
	 */
	public double calcularImporte() {
		return cantidad * precioUnitario;
	}
}

