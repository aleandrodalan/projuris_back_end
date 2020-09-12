package br.com.projuris.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDEM_SERVICO")
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 3272579074699534783L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Equipamento equipamento;
	
	@ManyToOne	
	private Responsavel responsavel;
	
	@ManyToOne	
	private Cliente cliente;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataEmissao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")	
	private LocalDateTime dataEncerramento;
	
	@Column(name = "DESCRICAO_PROBLEMA")	
	private String descricaoProblema;
	
	@Column(name = "SERVICO_REALIZADO")
	private String servicoRealizado;
	
	@PrePersist
	public void prePersist() {
		final LocalDateTime dataAtual = LocalDateTime.now();
		
		this.dataEmissao = dataAtual;
	}	
}