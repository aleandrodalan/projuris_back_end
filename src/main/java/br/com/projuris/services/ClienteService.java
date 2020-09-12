package br.com.projuris.services;

import java.util.List;
import java.util.Optional;

import br.com.projuris.models.Cliente;

public interface ClienteService {
	
	Cliente save(Cliente cliente);
	Cliente update(Cliente cliente);
	void deleteById(Long id);
	List<Cliente> findAll();
	Optional<Cliente> findById(Long id);	
}