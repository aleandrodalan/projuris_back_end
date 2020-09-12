package br.com.projuris.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projuris.models.Cliente;
import br.com.projuris.repositories.ClienteRepository;
import br.com.projuris.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente update(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}
}