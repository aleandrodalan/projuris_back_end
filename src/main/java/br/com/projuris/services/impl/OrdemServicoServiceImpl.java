package br.com.projuris.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projuris.models.OrdemServico;
import br.com.projuris.repositories.OrdemServicoRepository;
import br.com.projuris.services.OrdemServicoService;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

	@Autowired
	private OrdemServicoRepository repository;
	
	@Override
	public OrdemServico save(OrdemServico ordemServico) {
		return repository.save(ordemServico);
	}

	@Override
	public List<OrdemServico> findPendenteByResponsavelId(Long responsavelId) {
		return repository.findByResponsavelIdAndDataEncerramentoIsNull(responsavelId);
	}

	@Override
	public List<OrdemServico> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<OrdemServico> findById(Long id) {
		return repository.findById(id);
	}
}