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

import br.com.calculadora.dto.MedicamentoDTO;
import br.com.calculadora.form.MedicamentoForm;
import br.com.calculadora.service.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

	private MedicamentoService service;

	public MedicamentoController(MedicamentoService medService) {
		service = medService;
	}

	// METODOS CRUD

	@GetMapping
	public List<MedicamentoDTO> getMedicamentos() {
		List<MedicamentoDTO> listaMedicamentos = service.readAll();
		return listaMedicamentos;
	}

	@GetMapping(path = { "/{id}" })
	public MedicamentoDTO getMedicamentoById(@PathVariable Long id) {
		return service.readById(id);

	}

	@PostMapping
	public ResponseEntity<MedicamentoDTO> createMedicamento(@RequestBody @Valid MedicamentoForm medicamentoForm) {
		MedicamentoDTO medicamentoBody = service.save(medicamentoForm);
		// URI uri =
		// uriBuilder.path("/medicamento/{id}").buildAndExpand(medicamento.getIdMedicamento()).toUri()
		return ResponseEntity.ok().body(medicamentoBody);
	}

	@PutMapping(path = { "/{id}" })
	@Transactional
	public ResponseEntity<MedicamentoDTO> updateMedicamento(@PathVariable Long id,
			@RequestBody MedicamentoForm medicamentoForm) {
		MedicamentoDTO medicamentoBody = service.update(id, medicamentoForm);
		return ResponseEntity.ok().body(medicamentoBody);
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> deleteMedicamento(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
