package br.com.projuris.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projuris.models.Responsavel;

@SpringBootTest
public class ResponsavelRepositoryTest {

	@Autowired
	private ResponsavelRepository repository;
	
	private Responsavel responsavel = new Responsavel();
	
	@BeforeEach
	public void setUp() throws Exception {
		this.responsavel = Responsavel
								.builder()
								.nome("João das Couves")
								.build();
	}
	
	@AfterEach
    public final void tearDown() { 
		this.repository.deleteAll();
	}
	
	
	@Test
	public void salvarResponsavel() {
		Responsavel responsavelSalvo = repository.save(responsavel);
		Assertions.assertNotNull(responsavelSalvo);
	}
}
