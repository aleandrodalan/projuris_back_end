package br.com.projuris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projuris.models.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

}