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
public class EquipamentoDTO {

	private Long id;

	@NotNull(message = "Marca do equipamento é obrigatório")	
	private String marca;
	
	@NotNull(message = "Tipo do equipamento é obrigatório")
	private String tipo;
}
