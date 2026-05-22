package ar.edu.unpaz.rotiseria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unpaz.rotiseria.model.Producto;
import ar.edu.unpaz.rotiseria.repository.ProductoRepository;

@Service
public class ProductoService {

	private final ProductoRepository productoRepository;

	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	public List<Producto> listar() {
		return productoRepository.findAll();
	}

	public Producto guardar(Producto producto) {
		return productoRepository.save(producto);
	}
}

