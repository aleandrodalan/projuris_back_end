package br.com.projuris.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projuris.models.Ocorrencia;
import br.com.projuris.repositories.OcorrenciaRepository;
import br.com.projuris.services.OcorrenciaService;

@Service
public class OcorrenciaServiceImpl implements OcorrenciaService {

	@Autowired
	private OcorrenciaRepository repository;
	
	@Override
	public Ocorrencia save(Ocorrencia ocorrencia) {
		return repository.save(ocorrencia);
	}

	@Override
	public List<Ocorrencia> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Ocorrencia> findById(Long id) {
		return repository.findById(id);
	}
}