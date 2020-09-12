package br.com.projuris.services;

import java.util.List;
import java.util.Optional;

import br.com.projuris.models.Equipamento;

public interface EquipamentoService {
	
	Equipamento save(Equipamento equipamento);
	Equipamento update(Equipamento equipamento);
	void deleteById(Long id);
	List<Equipamento> findAll();
	Optional<Equipamento> findById(Long id);
}