package ar.edu.unpaz.rotiseria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unpaz.rotiseria.model.Pedido;

/**
 * Repositorio JPA para la entidad {@link Pedido}.
 *
 * Permite persistir y consultar pedidos sin implementar manualmente SQL para
 * las operaciones basicas.
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

