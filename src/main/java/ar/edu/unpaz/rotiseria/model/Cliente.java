package ar.edu.unpaz.rotiseria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa a una persona que realiza pedidos en la rotiseria.
 *
 * Es una entidad JPA, por lo que se persiste como tabla en la base de datos.
 * El campo {@code frecuente} permite distinguir clientes habituales para
 * futuras reglas comerciales.
 */
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String telefono;
	private boolean frecuente;

	/**
	 * Constructor requerido por JPA para reconstruir la entidad desde la base de
	 * datos.
	 */
	protected Cliente() {
	}

	/**
	 * Crea un cliente para ser registrado en el sistema.
	 *
	 * @param nombre nombre del cliente
	 * @param telefono telefono de contacto
	 * @param frecuente indica si es un cliente habitual
	 */
	public Cliente(String nombre, String telefono, boolean frecuente) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.frecuente = frecuente;
	}

	/**
	 * Obtiene el identificador tecnico generado por la base de datos.
	 *
	 * @return id del cliente
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Obtiene el nombre del cliente.
	 *
	 * @return nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el telefono de contacto.
	 *
	 * @return telefono del cliente
	 */
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Indica si el cliente es frecuente.
	 *
	 * @return {@code true} si el cliente es habitual
	 */
	public boolean isFrecuente() {
		return frecuente;
	}

	public void setFrecuente(boolean frecuente) {
		this.frecuente = frecuente;
	}
}

