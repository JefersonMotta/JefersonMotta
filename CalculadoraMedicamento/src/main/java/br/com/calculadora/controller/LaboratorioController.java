package br.com.calculadora.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calculadora.dto.LaboratorioDTO;
import br.com.calculadora.form.LaboratorioForm;
import br.com.calculadora.model.Laboratorio;
import br.com.calculadora.service.LaboratorioService;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

	private LaboratorioService service;

	public LaboratorioController(LaboratorioService labService) {
		service = labService;
	}

	@GetMapping
	public List<LaboratorioDTO> getLaboratorios() {
		List<Laboratorio> listaLaboratorios = service.readAllLab();
		return LaboratorioDTO.convertToLaboratorioDtoList(listaLaboratorios);
	}

	@GetMapping(path = { "/{id}" })
	public LaboratorioDTO getLaboratorioById(@PathVariable Long id) {
		return service.readByIdLab(id);
	}

	@PostMapping
	public ResponseEntity<Laboratorio> createLaboratorio(@RequestBody @Valid LaboratorioForm laboratorioForm) {
		Laboratorio laboratorio = service.saveLab(laboratorioForm);
		return ResponseEntity.ok().body(laboratorio);
	}

	@PutMapping(path = { "/{id}" })
	@Transactional
	public ResponseEntity<LaboratorioDTO> updateLaboratorio(@PathVariable Long id,
			@RequestBody @Valid LaboratorioForm laboratorioForm) {
		Laboratorio laboratorio = service.updateLab(id, laboratorioForm);
		return ResponseEntity.ok(new LaboratorioDTO(laboratorio));
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> deleteLaboratorio(@PathVariable Long id) {
		service.deleteLab(id);
		return ResponseEntity.ok().build();
	}

}
