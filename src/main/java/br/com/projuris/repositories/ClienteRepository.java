package br.com.projuris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projuris.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
