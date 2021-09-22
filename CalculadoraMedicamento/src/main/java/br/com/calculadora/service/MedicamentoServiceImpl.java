package br.com.calculadora.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.calculadora.dto.MedicamentoDTO;
import br.com.calculadora.exception.FormNomeException;
import br.com.calculadora.form.MedicamentoForm;
import br.com.calculadora.model.Medicamento;
import br.com.calculadora.repository.GrupoMedicamentoRepository;
import br.com.calculadora.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

	private MedicamentoRepository medicamentoRepository;
	private ModelMapper modelMapper;

	public MedicamentoServiceImpl(MedicamentoRepository medRepo, GrupoMedicamentoRepository grupoMedRepo) {
		medicamentoRepository = medRepo;
		modelMapper = new ModelMapper(); // instancia do ModelMapper
	}

	@Override
	public MedicamentoDTO save(MedicamentoForm medicamentoForm) {
		if (medicamentoForm.getMedicamentoNome().isBlank()) { // verifica se o nome vem vazio, criado manualmente porque
																// só com anotaçao não esta funcionando
			throw new FormNomeException();
		} else {
			Medicamento medicamento = convertToMedicamento(medicamentoForm);
			medicamentoRepository.save(medicamento); // sem conferir se ja existe pois pode ter mais de um
			return convertToMedicamentoDto(medicamento);
		}
	}

	@Override
	public List<MedicamentoDTO> readAll() {
		return medicamentoRepository.findAll().stream()
				.map(entity -> this.modelMapper.map(entity, MedicamentoDTO.class)).collect(Collectors.toList());
	}

	@Override
	public MedicamentoDTO readById(Long id) {
		Optional<Medicamento> med = medicamentoRepository.findById(id);
		Medicamento medicamento = med.orElseThrow(() -> new RuntimeException("Medicamento não encontrado."));
		return convertToMedicamentoDto(medicamento);
	}

	@Override
	public MedicamentoDTO update(Long id, MedicamentoForm medicamentoForm) {
		if (medicamentoForm.getMedicamentoNome().isBlank()) {
			throw new FormNomeException();
		} else {
			Medicamento medicamento = medicamentoRepository.getById(id);
			medicamento.setGrupoMedicamentoId(medicamentoForm.getGrupoMedicamentoId());
			medicamento.setLaboratorioId(medicamentoForm.getLaboratorioId());
			medicamento.setMedicamentoNome(medicamentoForm.getMedicamentoNome());
			MedicamentoDTO medicamentoBody = convertToMedicamentoDto(medicamento);
			return medicamentoBody;
		}
	}

	@Override
	public void delete(Long id) {
		medicamentoRepository.deleteById(id);
	}

	// Conversões

	private Medicamento convertToMedicamento(MedicamentoDTO medDto) {
		Medicamento medicamento = modelMapper.map(medDto, Medicamento.class);
		return medicamento;
	}

	private Medicamento convertToMedicamento(MedicamentoForm medForm) {
		Medicamento medicamento = modelMapper.map(medForm, Medicamento.class);
		return medicamento;
	}

	private MedicamentoDTO convertToMedicamentoDto(Medicamento medicamento) {
		return modelMapper.map(medicamento, MedicamentoDTO.class);
	}

}
