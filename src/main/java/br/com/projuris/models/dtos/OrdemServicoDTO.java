package br.com.projuris.models.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.projuris.models.Cliente;
import br.com.projuris.models.Equipamento;
import br.com.projuris.models.Responsavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServicoDTO {

	private Long id;
	
	@NotNull(message = "Equipamento é obrigatório")
	private Equipamento equipamento;
	
	@NotNull(message = "Responsável é obrigatório")
	private Responsavel responsavel;
	
	@NotNull(message = "Cliente é obrigatório")
	private Cliente cliente;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataEmissao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")	
	private LocalDateTime dataEncerramento;
	
	@NotNull(message = "Descrição do problema é obrigatório")
	private String descricaoProblema;

	private String servicoRealizado;	
}
