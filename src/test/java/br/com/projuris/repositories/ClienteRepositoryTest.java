package br.com.projuris.repositories;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projuris.models.Cliente;

@SpringBootTest
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository repository;
	
	private Cliente cliente = new Cliente();
	
	@BeforeEach
	public void setUp() throws Exception {
		this.cliente = Cliente
							.builder()
							.nome("João das Couves")
							.email("joaodascouves@teste.com")
							.endereco("Avenida Brasil, 150 - Centro - São Paulo/SP")
							.telefone("(11) 99999-1212")
							.build();
	}
	
	@AfterEach
    public final void tearDown() { 
		this.repository.deleteAll();
	}
	
	@Test
	public void salvarCliente() {
		Cliente clienteSalvo = repository.save(this.cliente);
		Assertions.assertNotNull(clienteSalvo);
	}
	
	@Test
	public void buscarClientePorId() {
		Optional<Cliente> cliente = repository.findById(1L);
		Assertions.assertNotNull(cliente);
	}
}
