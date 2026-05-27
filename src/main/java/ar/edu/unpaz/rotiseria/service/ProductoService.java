package ar.edu.unpaz.rotiseria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unpaz.rotiseria.model.Producto;
import ar.edu.unpaz.rotiseria.repository.ProductoRepository;

/**
 * Servicio de aplicacion para operaciones de productos.
 *
 * Encapsula las llamadas al repositorio y deja preparada una capa donde
 * agregar reglas de negocio relacionadas con el menu.
 */
@Service
public class ProductoService {

	private final ProductoRepository productoRepository;

	/**
	 * Crea el servicio con el repositorio de productos requerido.
	 *
	 * @param productoRepository repositorio JPA de productos
	 */
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	/**
	 * Obtiene todos los productos cargados.
	 *
	 * @return lista completa de productos
	 */
	public List<Producto> listar() {
		return productoRepository.findAll();
	}

	/**
	 * Guarda un producto nuevo o actualiza uno existente si ya tiene id.
	 *
	 * @param producto producto a persistir
	 * @return producto persistido
	 */
	public Producto guardar(Producto producto) {
		return productoRepository.save(producto);
	}
}

