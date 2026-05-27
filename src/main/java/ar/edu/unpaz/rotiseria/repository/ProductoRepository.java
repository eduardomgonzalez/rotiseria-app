package ar.edu.unpaz.rotiseria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unpaz.rotiseria.model.Producto;

/**
 * Repositorio JPA para la entidad {@link Producto}.
 *
 * Centraliza el acceso a datos de productos y deja disponible la API CRUD
 * generada por Spring Data.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

