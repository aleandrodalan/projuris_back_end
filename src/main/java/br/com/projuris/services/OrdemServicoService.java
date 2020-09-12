package br.com.projuris.services;

import java.util.List;
import java.util.Optional;

import br.com.projuris.models.OrdemServico;

public interface OrdemServicoService {
	
	OrdemServico save(OrdemServico ordemServico);
	List<OrdemServico> findPendenteByResponsavelId(Long responsavelId);
	List<OrdemServico> findAll();
	Optional<OrdemServico> findById(Long id);
}