package ar.edu.unpaz.rotiseria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unpaz.rotiseria.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

