package br.com.calculadora.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.calculadora.dto.LaboratorioDTO;
import br.com.calculadora.exception.FormNomeException;
import br.com.calculadora.form.LaboratorioForm;
import br.com.calculadora.model.Laboratorio;
import br.com.calculadora.repository.LaboratorioRepository;

@Service
public class LaboratorioServiceImpl implements LaboratorioService {

	private LaboratorioRepository labRepository;
	private ModelMapper modelMapper;

	public LaboratorioServiceImpl(LaboratorioRepository labRepo) {
		labRepository = labRepo;
		modelMapper = new ModelMapper();
	}

	@Override
	public Laboratorio saveLab(LaboratorioForm laboratorioForm) {
		if (laboratorioForm.getNome().isBlank()) {
			throw new FormNomeException();
		} else {
			Long quantLabs = labRepository.countByNome(laboratorioForm.getNome());
			if (quantLabs >= 1) {
				throw new RuntimeException("Registro já existente.");
			} else {
				return labRepository.save(convertToLaboratorio(laboratorioForm));
			}
		}
	}

	@Override
	public List<Laboratorio> readAllLab() {
		return labRepository.findAll();
	}

	@Override
	public LaboratorioDTO readByIdLab(Long id) {
		Optional<Laboratorio> lab = labRepository.findById(id);
		Laboratorio laboratorio = lab.orElseThrow(() -> new FormNomeException());
		return convertToLaboratorioDto(laboratorio);
	}

	@Override
	public Laboratorio updateLab(Long id, LaboratorioForm laboratorioForm) {
		if (laboratorioForm.getNome().isBlank()) {
			throw new RuntimeException("Nome invalido");
		} else {
			Laboratorio laboratorio = labRepository.getById(id); // utilizando getById
			laboratorio.setNomeLaboratorio(laboratorioForm.getNome());
			return laboratorio;
		}
	}

	@Override
	public void deleteLab(Long id) {
		boolean alreadyExist = labRepository.existsById(id);
		if (alreadyExist) {
			labRepository.deleteById(id);
		} else {
			throw new RuntimeException("Laboratorio não encontrado.");
		}
	}

	private LaboratorioDTO convertToLaboratorioDto(Laboratorio lab) {
		return modelMapper.map(lab, LaboratorioDTO.class);
	}

	private Laboratorio convertToLaboratorio(LaboratorioDTO labDto) {
		return modelMapper.map(labDto, Laboratorio.class);
	}

	private Laboratorio convertToLaboratorio(LaboratorioForm labForm) {
		return modelMapper.map(labForm, Laboratorio.class);
	}

}
