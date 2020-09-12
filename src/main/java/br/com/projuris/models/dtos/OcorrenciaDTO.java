package br.com.projuris.models.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.projuris.models.OrdemServico;
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
public class OcorrenciaDTO {
	
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataOcorrencia;	
	
	@NotNull(message = "Descrição é obrigatório.")
	private String descricao;
	
	@NotNull(message = "Ordem de Serviço é obrigatório.")
	private OrdemServico ordemServico;

}