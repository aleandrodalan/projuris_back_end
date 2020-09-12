package br.com.projuris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projuris.models.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

}