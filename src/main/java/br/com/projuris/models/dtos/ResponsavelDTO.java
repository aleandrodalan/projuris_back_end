package br.com.projuris.models.dtos;

import javax.validation.constraints.NotNull;

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
public class ResponsavelDTO {

	private Long id;
	
	@NotNull(message = "Nome do responsável é obrigatório")
	private String nome;
}