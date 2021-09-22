package br.com.calculadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;

	public Long getIdLaboratorio() {
		return id;
	}

	public String getNomeLaboratorio() {
		return nome;
	}

	public void setNomeLaboratorio(String nomeLaboratorio) {
		this.nome = nomeLaboratorio;
	}

}
