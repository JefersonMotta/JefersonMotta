package br.com.calculadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calculadora.model.Laboratorio;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {
	Long countByNome(String nome);
}
