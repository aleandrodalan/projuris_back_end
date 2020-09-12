package br.com.projuris.models.dtos;

import javax.validation.constraints.Email;
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
public class ClienteDTO {

	private Long id;
	
	@NotNull(message = "Nome do cliente é obrigatório")
	private String nome;
	
	@NotNull(message = "Endereço do cliente é obrigatório")	
	private String endereco;
	
	private String telefone;

	@Email(message = "E-mail inválido")
	@NotNull(message = "E-mail do cliente é obrigatório")
	private String email;	
}
