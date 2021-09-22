package br.com.calculadora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_medicamento")
public class GrupoMedicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	public Long getIdGrupoMedicamento() {
		return id;
	}

	public String getNomeGrupoMedicamento() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nomeGrupoMedicamento) {
		this.nome = nomeGrupoMedicamento;
	}

}
