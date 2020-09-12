package br.com.projuris.services;

import java.util.List;
import java.util.Optional;

import br.com.projuris.models.Ocorrencia;

public interface OcorrenciaService {

	Ocorrencia save(Ocorrencia ocorrencia);
	List<Ocorrencia> findAll();
	Optional<Ocorrencia> findById(Long id);	
}
