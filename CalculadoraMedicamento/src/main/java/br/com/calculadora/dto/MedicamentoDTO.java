package br.com.calculadora.dto;

import br.com.calculadora.model.Medicamento;

public class MedicamentoDTO {
	private Long id;
	private Integer grupoMedicamentoId;
	private Integer laboratorioId;
	private String medicamentoNome;

	public MedicamentoDTO() {
	}

	public MedicamentoDTO(Long id, Integer idGrupoMedicamento, Integer idLaboratorio, String nome) {
		this.id = id;
		this.grupoMedicamentoId = idGrupoMedicamento;
		this.laboratorioId = idLaboratorio;
		this.medicamentoNome = nome;
	}

	public MedicamentoDTO(Integer idGrupoMedicamento, Integer idLaboratorio, String nome) {
		this.grupoMedicamentoId = idGrupoMedicamento;
		this.laboratorioId = idLaboratorio;
		this.medicamentoNome = nome;
	}

	public MedicamentoDTO(Medicamento medicamento) {
		this.id = medicamento.getIdMedicamento();
		this.medicamentoNome = medicamento.getMedicamentoNome();
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

	// public static List<MedicamentoDTO>
	// convertToMedicamentoDtoList(List<Medicamento> listaMedicamentos){
	// return listaMedicamentos.stream().map(MedicamentoDTO::
	// new).collect(Collectors.toList()); // converte uma lista de medicamentos
	// direto pelo construtor da DTO
	// }

}
