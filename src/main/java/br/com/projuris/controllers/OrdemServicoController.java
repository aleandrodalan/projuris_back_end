package br.com.projuris.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projuris.models.OrdemServico;
import br.com.projuris.models.dtos.OrdemServicoDTO;
import br.com.projuris.services.OrdemServicoService;

@Transactional
@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoController {
	
	@Autowired
	private OrdemServicoService service;
	
	@Transactional(readOnly = true)
	@GetMapping
	public List<OrdemServico> listarTodas() {
		return service.findAll();
	}
	
	@Transactional(readOnly = true)
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrdemServico listarPorId(@PathVariable("id") Long id) {
		Optional<OrdemServico> ordemServico = service.findById(id);
		
		if (!ordemServico.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
											  new Exception("Ordem de Serviço não encontrado.").getMessage());
		
		return ordemServico.get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico salvar(@Valid @RequestBody OrdemServicoDTO dto) {
		OrdemServico ordemServicoSalvo = service.save(convertDtoToEntity(dto));
		
		if (ordemServicoSalvo == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST); 
		}
		
		return ordemServicoSalvo;
	}
	
	@Transactional(readOnly = true)
	@GetMapping("/responsavel/{id}")
	public List<OrdemServico> listarPendentePorResponsavel(@PathVariable("id") Long id) {
		return service.findPendenteByResponsavelId(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)	
	public OrdemServico terminoServico(@PathVariable("id") Long id, @RequestBody OrdemServicoDTO dto) {
		Optional<OrdemServico> ordemServico = service.findById(id);
		
		if (!ordemServico.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
											  new Exception("Ordem de Serviço não encontrada.").getMessage());
		}
		
		ordemServico.get().setDataEncerramento(dto.getDataEncerramento());
		ordemServico.get().setServicoRealizado(dto.getServicoRealizado());

		return service.save(ordemServico.get());
	}
	
	private OrdemServico convertDtoToEntity(OrdemServicoDTO dto) {
		return OrdemServico
					.builder()
					.id(dto.getId())
					.cliente(dto.getCliente())
					.dataEmissao(dto.getDataEmissao())
					.dataEncerramento(dto.getDataEncerramento())
					.descricaoProblema(dto.getDescricaoProblema())
					.equipamento(dto.getEquipamento())
					.responsavel(dto.getResponsavel())
					.servicoRealizado(dto.getServicoRealizado())
					.build();
	}

}
