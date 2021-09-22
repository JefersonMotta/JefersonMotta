package br.com.calculadora.service;

import java.util.List;

import br.com.calculadora.dto.LaboratorioDTO;
import br.com.calculadora.form.LaboratorioForm;
import br.com.calculadora.model.Laboratorio;

public interface LaboratorioService {
	public Laboratorio saveLab(LaboratorioForm laboratorioForm);

	public List<Laboratorio> readAllLab();

	public LaboratorioDTO readByIdLab(Long id);

	public Laboratorio updateLab(Long id, LaboratorioForm laboratorioForm);

	public void deleteLab(Long id);
}
