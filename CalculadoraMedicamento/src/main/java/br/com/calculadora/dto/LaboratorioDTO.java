package br.com.calculadora.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.calculadora.model.Laboratorio;

public class LaboratorioDTO {
	private Long id;
	private String nome;

	public LaboratorioDTO() {

	}

	public LaboratorioDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public LaboratorioDTO(Laboratorio lab) {
		id = lab.getIdLaboratorio();
		nome = lab.getNomeLaboratorio();
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

	public static List<LaboratorioDTO> convertToLaboratorioDtoList(List<Laboratorio> listaLabs) {
		return listaLabs.stream().map(LaboratorioDTO::new).collect(Collectors.toList());
	}

}
