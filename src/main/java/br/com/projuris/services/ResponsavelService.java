package br.com.projuris.services;

import java.util.List;
import java.util.Optional;

import br.com.projuris.models.Responsavel;

public interface ResponsavelService {

	Responsavel save(Responsavel responsavel);
	void deleteById(Long id);
	List<Responsavel> findAll();
	Optional<Responsavel> findById(Long id);
}