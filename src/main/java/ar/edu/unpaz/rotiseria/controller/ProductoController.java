package ar.edu.unpaz.rotiseria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unpaz.rotiseria.model.Producto;
import ar.edu.unpaz.rotiseria.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@GetMapping
	public List<Producto> listar() {
		return productoService.listar();
	}

	@PostMapping
	public Producto crear(@RequestBody Producto producto) {
		return productoService.guardar(producto);
	}
}

