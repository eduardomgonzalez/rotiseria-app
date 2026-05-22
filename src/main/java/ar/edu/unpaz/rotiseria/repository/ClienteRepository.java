package ar.edu.unpaz.rotiseria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unpaz.rotiseria.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

