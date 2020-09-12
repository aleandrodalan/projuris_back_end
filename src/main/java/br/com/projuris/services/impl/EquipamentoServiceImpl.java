package br.com.projuris.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projuris.models.Equipamento;
import br.com.projuris.repositories.EquipamentoRepository;
import br.com.projuris.services.EquipamentoService;

@Service
public class EquipamentoServiceImpl implements EquipamentoService {

	@Autowired
	private EquipamentoRepository repository;

	@Override
	public Equipamento save(Equipamento equipamento) {
		return repository.save(equipamento);
	}

	@Override
	public Equipamento update(Equipamento equipamento) {
		return repository.save(equipamento);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Equipamento> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Equipamento> findById(Long id) {
		return repository.findById(id);
	}
}