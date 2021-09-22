package br.com.calculadora.service;

import java.util.List;

import br.com.calculadora.dto.GrupoMedicamentoDTO;
import br.com.calculadora.form.GrupoMedicamentoForm;

public interface GrupoMedicamentoService {
	public GrupoMedicamentoDTO saveGrupoMedicamento(GrupoMedicamentoForm grupoMedicamentoForm);

	public List<GrupoMedicamentoDTO> readAllGrupos();

	public GrupoMedicamentoDTO readByIdGrupoMedicamento(Long id);

	public GrupoMedicamentoDTO updateGrupoMedicamento(Long id, GrupoMedicamentoForm grupoMedicamentoForm);

	public void deleteGrupoMedicamento(Long id);
}
