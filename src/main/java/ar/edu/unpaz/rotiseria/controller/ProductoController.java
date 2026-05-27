package ar.edu.unpaz.rotiseria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unpaz.rotiseria.model.Producto;
import ar.edu.unpaz.rotiseria.service.ProductoService;

/**
 * Controlador REST para administrar productos del menu.
 *
 * Recibe solicitudes HTTP para listar y crear productos. La persistencia se
 * realiza indirectamente a traves de {@link ProductoService}.
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {

	private final ProductoService productoService;

	/**
	 * Crea el controlador con el servicio de productos requerido.
	 *
	 * @param productoService servicio que resuelve operaciones sobre productos
	 */
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	/**
	 * Lista todos los productos cargados.
	 *
	 * @return productos disponibles y no disponibles registrados
	 */
	@GetMapping
	public List<Producto> listar() {
		return productoService.listar();
	}

	/**
	 * Crea un nuevo producto desde el JSON recibido.
	 *
	 * @param producto datos del producto enviado por el cliente HTTP
	 * @return producto guardado con su identificador generado
	 */
	@PostMapping
	public Producto crear(@RequestBody Producto producto) {
		return productoService.guardar(producto);
	}
}

