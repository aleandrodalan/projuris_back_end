package br.com.projuris.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projuris.models.Responsavel;
import br.com.projuris.models.dtos.ResponsavelDTO;
import br.com.projuris.services.ResponsavelService;

@Transactional
@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

	@Autowired
	private ResponsavelService service;
	
	@Transactional(readOnly = true)
	@GetMapping
	public List<Responsavel> listarTodos() {
		return service.findAll();
	}
	
	@Transactional(readOnly = true)	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Responsavel>> listarPorId(@PathVariable("id") Long id) {
		Optional<Responsavel> responsavel = service.findById(id);
		
		if (!responsavel.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
											  new Exception("Responsável não encontrado.").getMessage());
		}
		
		return ResponseEntity.ok(responsavel);
	}
	
	@PostMapping
	public ResponseEntity<Responsavel> salvar(@Valid @RequestBody ResponsavelDTO dto) {
		Responsavel responsavel = service.save(convertDtoToEntity(dto));
		return responsavel != null ? ResponseEntity.ok(responsavel) : ResponseEntity.badRequest().build();
	}
	
	private Responsavel convertDtoToEntity(ResponsavelDTO dto) {
		return Responsavel
					.builder()
					.id(dto.getId())
					.nome(dto.getNome())
					.build();
	}
}
