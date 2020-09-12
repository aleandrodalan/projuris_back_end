package br.com.projuris.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.projuris.models.Equipamento;
import br.com.projuris.models.dtos.EquipamentoDTO;
import br.com.projuris.services.EquipamentoService;

@Transactional
@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {
	
	@Autowired
	private EquipamentoService service;
	
	@Transactional(readOnly = true)	
	@GetMapping
	public List<Equipamento> listarTodos() {
		return service.findAll();
	}
	
	@Transactional(readOnly = true)
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Equipamento listarPorId(@PathVariable("id") Long id) {
		Optional<Equipamento> equipamento = service.findById(id);

		if (!equipamento.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
											  new Exception("Equipamento não encontrado.").getMessage());
		}	

		return equipamento.get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Equipamento salvar(@Valid @RequestBody EquipamentoDTO dto) {
		Equipamento equipamentoSalvo = service.save(convertDtoToEntity(dto));
		
		if (equipamentoSalvo == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		
		return equipamentoSalvo;
	}
	
	private Equipamento convertDtoToEntity(EquipamentoDTO dto) {
		return Equipamento
					.builder()
					.id(dto.getId())
					.marca(dto.getMarca())
					.tipo(dto.getTipo())
					.build();
	}
}