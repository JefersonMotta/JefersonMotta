package br.com.calculadora.form;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MedicamentoForm {
	
	private Long id;
	
	@NotNull @NotEmpty
	private Integer grupoMedicamentoId;
	
	@NotNull @NotEmpty
	private Integer laboratorioId;
	
	@NotBlank 
	private String medicamentoNome;
	
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
