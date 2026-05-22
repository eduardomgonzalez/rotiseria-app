package ar.edu.unpaz.rotiseria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unpaz.rotiseria.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

