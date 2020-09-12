package br.com.projuris.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.projuris.models.Equipamento;
import br.com.projuris.repositories.EquipamentoRepository;

@SpringBootTest
public class EquipamentoServiceTest {
	
	@MockBean
	private EquipamentoRepository repository;
	
	@Autowired
	private EquipamentoService service;
	
	@BeforeEach
	public void setUp() throws Exception {
		BDDMockito.given(this.repository.findById(Mockito.anyLong())).willReturn(Optional.ofNullable(new Equipamento()));
		BDDMockito.given(this.repository.save(Mockito.any(Equipamento.class))).willReturn(new Equipamento());
	}
	
	@Test
	public void testBuscarPorId() {
		Optional<Equipamento> equipamento = this.service.findById(1L);
		
		Assertions.assertTrue(equipamento.isPresent());
	}
	
	@Test
	public void testSalvar() {
		Equipamento equipamento = this.service.save(new Equipamento());
		Assertions.assertNotNull(equipamento);
	}
	

}
