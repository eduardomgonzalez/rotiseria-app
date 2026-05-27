package ar.edu.unpaz.rotiseria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Producto ofrecido por la rotiseria.
 *
 * Contiene los datos basicos que se muestran en el menu y que luego se usan
 * para calcular los importes de los pedidos.
 */
@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String descripcion;
	private double precio;
	private boolean disponible;

	/**
	 * Constructor requerido por JPA para hidratar la entidad.
	 */
	protected Producto() {
	}

	/**
	 * Crea un producto del menu.
	 *
	 * @param nombre nombre comercial del producto
	 * @param descripcion descripcion visible para el cliente
	 * @param precio precio unitario actual
	 * @param disponible indica si el producto puede venderse
	 */
	public Producto(String nombre, String descripcion, double precio, boolean disponible) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.disponible = disponible;
	}

	/**
	 * Obtiene el identificador tecnico generado por la base de datos.
	 *
	 * @return id del producto
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Obtiene el nombre del producto.
	 *
	 * @return nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la descripcion del producto.
	 *
	 * @return descripcion del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el precio unitario vigente.
	 *
	 * @return precio unitario
	 */
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Indica si el producto se encuentra disponible para la venta.
	 *
	 * @return {@code true} si se puede vender
	 */
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}

