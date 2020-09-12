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

import br.com.projuris.models.Cliente;
import br.com.projuris.models.dtos.ClienteDTO;
import br.com.projuris.services.ClienteService;

@Transactional
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@Transactional(readOnly = true)
	@GetMapping
	public List<Cliente> listarTodos() {
		return service.findAll();
	}
	
	@Transactional(readOnly = true)
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Long id) {
		Optional<Cliente> cliente = service.findById(id);
		
		if (!cliente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
											  new Exception("Cliente não encontrado.").getMessage());
		}
		
		return ResponseEntity.ok(cliente.get());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> salvar(@Valid @RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = service.save(convertDtoToEntity(clienteDTO));
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.badRequest().build();
	}
	
	private Cliente convertDtoToEntity(ClienteDTO dto) {
		return Cliente
					.builder()
					.id(dto.getId())
					.email(dto.getEmail())
					.endereco(dto.getEndereco())
					.nome(dto.getNome())
					.telefone(dto.getTelefone())
					.build();
	}
}
