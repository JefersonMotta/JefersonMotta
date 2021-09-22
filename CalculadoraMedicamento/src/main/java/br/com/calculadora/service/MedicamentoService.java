package br.com.calculadora.service;

import java.util.List;

import br.com.calculadora.dto.MedicamentoDTO;
import br.com.calculadora.form.MedicamentoForm;

public interface MedicamentoService {
	public MedicamentoDTO save(MedicamentoForm medicamentoForm);

	public List<MedicamentoDTO> readAll();

	public MedicamentoDTO readById(Long id);

	public MedicamentoDTO update(Long id, MedicamentoForm medicamentoForm);

	public void delete(Long id);
}
