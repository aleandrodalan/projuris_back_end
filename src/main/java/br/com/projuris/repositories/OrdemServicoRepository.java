package br.com.projuris.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projuris.models.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
	
	List<OrdemServico> findByResponsavelIdAndDataEncerramentoIsNull(Long responsavelId);
}