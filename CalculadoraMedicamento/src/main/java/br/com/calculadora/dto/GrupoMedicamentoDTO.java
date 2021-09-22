package br.com.calculadora.dto;

import br.com.calculadora.model.GrupoMedicamento;

public class GrupoMedicamentoDTO {
	private Long id;
	private String nome;

	public GrupoMedicamentoDTO() {
	}

	public GrupoMedicamentoDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public GrupoMedicamentoDTO(GrupoMedicamento grupoMedicamento) {
		id = grupoMedicamento.getIdGrupoMedicamento();
		nome = grupoMedicamento.getNomeGrupoMedicamento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
