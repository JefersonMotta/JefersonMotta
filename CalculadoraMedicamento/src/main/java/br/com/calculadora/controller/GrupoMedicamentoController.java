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

import br.com.calculadora.dto.GrupoMedicamentoDTO;
import br.com.calculadora.form.GrupoMedicamentoForm;
import br.com.calculadora.service.GrupoMedicamentoService;

@RestController
@RequestMapping("/grupoMedicamento")
public class GrupoMedicamentoController {

	private GrupoMedicamentoService service;

	public GrupoMedicamentoController(GrupoMedicamentoService grupoMedService) {
		service = grupoMedService;
	}

	// metodos crud
	@GetMapping
	public List<GrupoMedicamentoDTO> getGrupos() {
		return service.readAllGrupos();
	}

	@GetMapping(path = { "/{id}" })
	public GrupoMedicamentoDTO getGrupoMedicamentoById(@PathVariable Long id) {
		return service.readByIdGrupoMedicamento(id);
	}

	@PostMapping
	public ResponseEntity<GrupoMedicamentoDTO> createGrupoMedicamento(
			@RequestBody @Valid GrupoMedicamentoForm grupoMedicamentoForm) {
		GrupoMedicamentoDTO grupoMedicamentoResposta = service.saveGrupoMedicamento(grupoMedicamentoForm);
		return ResponseEntity.ok().body(grupoMedicamentoResposta);
	}

	@PutMapping(path = { "/{id}" })
	@Transactional
	public ResponseEntity<GrupoMedicamentoDTO> updateGrupoMedicamento(@PathVariable Long id,
			@RequestBody @Valid GrupoMedicamentoForm grupoMedicamentoForm) {

		GrupoMedicamentoDTO grupoMedResponse = service.updateGrupoMedicamento(id, grupoMedicamentoForm);
		return ResponseEntity.ok().body(grupoMedResponse);
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> deleteGrupoMedicamento(@PathVariable Long id) {
		service.deleteGrupoMedicamento(id);
		return ResponseEntity.ok().build();
	}

}
