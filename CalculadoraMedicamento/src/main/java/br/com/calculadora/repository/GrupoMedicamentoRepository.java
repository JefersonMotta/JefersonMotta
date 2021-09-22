package br.com.calculadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calculadora.model.GrupoMedicamento;

public interface GrupoMedicamentoRepository extends JpaRepository<GrupoMedicamento, Long> {
	Long countByNome(String nome);
}
