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
@Table(name = "OCORRENCIA")
public class Ocorrencia implements Serializable {

	private static final long serialVersionUID = 2114617233065377038L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataOcorrencia;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@ManyToOne
	private OrdemServico ordemServico;
	
	@PrePersist
	public void prePersist() {
		final LocalDateTime dataAtual = LocalDateTime.now();
		
		this.dataOcorrencia = dataAtual;
	}
}
