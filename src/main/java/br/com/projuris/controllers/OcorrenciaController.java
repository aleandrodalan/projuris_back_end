package br.com.projuris.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projuris.models.Ocorrencia;
import br.com.projuris.models.dtos.OcorrenciaDTO;
import br.com.projuris.services.OcorrenciaService;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

	@Autowired
	private OcorrenciaService service;
	
	@GetMapping
	public List<Ocorrencia> listarTodos() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Ocorrencia listarPorId(@PathVariable("id") Long id) {
		Optional<Ocorrencia> ocorrencia = service.findById(id);
		
		if (!ocorrencia.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
											  new Exception("Ocorrencia não encontrada.").getMessage());
		
		return ocorrencia.get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Ocorrencia salvar(@Valid @RequestBody OcorrenciaDTO dto) {
		Ocorrencia ocorrenciaSalva = service.save(convertDtoToEntity(dto));
		
		if (ocorrenciaSalva == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		
		return ocorrenciaSalva;
	}
	
	private Ocorrencia convertDtoToEntity(OcorrenciaDTO dto) {
		return Ocorrencia
					.builder()
					.descricao(dto.getDescricao())
					.id(dto.getId())
					.ordemServico(dto.getOrdemServico())
					.build();
	}
}