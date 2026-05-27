package ar.edu.unpaz.rotiseria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unpaz.rotiseria.model.Cliente;

/**
 * Repositorio JPA para la entidad {@link Cliente}.
 *
 * Al extender {@link JpaRepository}, Spring Data genera automaticamente
 * operaciones CRUD como {@code findAll}, {@code findById}, {@code save} y
 * {@code delete}.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

