package br.com.calculadora.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.calculadora.dto.GrupoMedicamentoDTO;
import br.com.calculadora.exception.FormNomeException;
import br.com.calculadora.form.GrupoMedicamentoForm;
import br.com.calculadora.model.GrupoMedicamento;
import br.com.calculadora.repository.GrupoMedicamentoRepository;

@Service
public class GrupoMedicamentoServiceImpl implements GrupoMedicamentoService {

	private GrupoMedicamentoRepository grupoMedRepository;
	private ModelMapper modelMapper;

	public GrupoMedicamentoServiceImpl(GrupoMedicamentoRepository grupoMedRepo) {
		grupoMedRepository = grupoMedRepo;
		modelMapper = new ModelMapper(); // instancia do ModelMapper
	}

	@Override
	public GrupoMedicamentoDTO saveGrupoMedicamento(GrupoMedicamentoForm grupoMedicamentoForm) {
		if (grupoMedicamentoForm.getNome().isBlank()) {
			throw new FormNomeException();
		} else {
			Long quantGrupoMed = grupoMedRepository.countByNome(grupoMedicamentoForm.getNome());
			if (quantGrupoMed >= 1) {
				throw new RuntimeException("Este grupo de medicamento já está registrado");
			} else {
				GrupoMedicamento grupoMedicamento = grupoMedRepository
						.save(convertToGrupoMedicamento(grupoMedicamentoForm));
				return convertToGrupoMedicamentoDto(grupoMedicamento);
			}
		}
	}

	@Override
	public List<GrupoMedicamentoDTO> readAllGrupos() {
		return grupoMedRepository.findAll().stream()
				.map(entity -> this.modelMapper.map(entity, GrupoMedicamentoDTO.class)).collect(Collectors.toList());
	}

	@Override
	public GrupoMedicamentoDTO readByIdGrupoMedicamento(Long id) {
		Optional<GrupoMedicamento> grupoMedicamento = grupoMedRepository.findById(id);
		return convertToGrupoMedicamentoDto(
				grupoMedicamento.orElseThrow(() -> new RuntimeException("Grupo de Medicamentos não encontrado.")));
	}

	@Override
	public GrupoMedicamentoDTO updateGrupoMedicamento(Long id, GrupoMedicamentoForm grupoMedicamentoForm) {
		if (grupoMedicamentoForm.getNome().isBlank()) {
			throw new FormNomeException();
		} else {
			GrupoMedicamento grupoMedicamento = grupoMedRepository.getById(id);
			grupoMedicamento.setNome(grupoMedicamentoForm.getNome());
			return convertToGrupoMedicamentoDto(grupoMedicamento);
		}
	}

	@Override
	public void deleteGrupoMedicamento(Long id) {
		grupoMedRepository.deleteById(id);
	}

	private GrupoMedicamentoDTO convertToGrupoMedicamentoDto(GrupoMedicamento grupoMed) {
		return modelMapper.map(grupoMed, GrupoMedicamentoDTO.class);
	}

	private GrupoMedicamento convertToGrupoMedicamento(GrupoMedicamentoDTO grupoMedDto) {
		return modelMapper.map(grupoMedDto, GrupoMedicamento.class);
	}

	private GrupoMedicamento convertToGrupoMedicamento(GrupoMedicamentoForm grupoMedForm) {
		return modelMapper.map(grupoMedForm, GrupoMedicamento.class);
	}

}
