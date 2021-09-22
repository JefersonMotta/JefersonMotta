package br.com.calculadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calculadora.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
