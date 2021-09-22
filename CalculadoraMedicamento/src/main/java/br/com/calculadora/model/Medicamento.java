package br.com.calculadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicamento")
public class Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "grupo_medicamento_id", nullable = false, insertable = true, updatable = true)
	private Integer grupoMedicamentoId;

	// @ManyToOne
	// @JoinColumn(name="grupo_medicamento_id", referencedColumnName="id",
	// nullable=false, insertable=false, updatable=false)
	// private GrupoMedicamento grupoMedicamento;

	@Column(name = "laboratorio_id", nullable = false, insertable = true, updatable = true)
	private Integer laboratorioId;

	// @ManyToOne()
	// @JoinColumn(name="laboratorio_id", referencedColumnName="id", nullable=false,
	// insertable=false, updatable=false)
	// private Laboratorio laboratorio;

	@Column(name = "nome")
	private String medicamentoNome;

	public long getIdMedicamento() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGrupoMedicamentoId() {
		return grupoMedicamentoId;
	}

	public void setGrupoMedicamentoId(Integer grupoMedicamentoId) {
		this.grupoMedicamentoId = grupoMedicamentoId;
	}

	public Integer getLaboratorioId() {
		return laboratorioId;
	}

	public void setLaboratorioId(Integer laboratorioId) {
		this.laboratorioId = laboratorioId;
	}

	public String getMedicamentoNome() {
		return medicamentoNome;
	}

	public void setMedicamentoNome(String medicamentoNome) {
		this.medicamentoNome = medicamentoNome;
	}

}
