package br.com.projuris.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projuris.models.Responsavel;
import br.com.projuris.repositories.ResponsavelRepository;
import br.com.projuris.services.ResponsavelService;

@Service
public class ResponsavelServiceImpl implements ResponsavelService {

	@Autowired
	private ResponsavelRepository repository;

	@Override
	public Responsavel save(Responsavel responsavel) {
		return repository.save(responsavel);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Responsavel> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Responsavel> findById(Long id) {
		return repository.findById(id);
	}
}