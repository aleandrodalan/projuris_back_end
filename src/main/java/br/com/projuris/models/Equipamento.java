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
@Table(name = "EQUIPAMENTO")
public class Equipamento implements Serializable {

	private static final long serialVersionUID = -1405331019080166442L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "MARCA")
	private String marca;
	
	@Column(name = "TIPO")
	private String tipo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipamento")
	private List<OrdemServico> ordensServicos;
}