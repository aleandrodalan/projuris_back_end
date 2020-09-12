package br.com.projuris.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 4649810706495119199L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOME")	
	private String nome;
	
	@Column(name = "ENDERECO")	
	private String endereco;
	
	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "EMAIL")
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<OrdemServico> ordensServicos;
}