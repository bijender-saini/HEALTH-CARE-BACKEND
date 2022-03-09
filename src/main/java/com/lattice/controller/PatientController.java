package com.lattice.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.dto.PatientDto;
import com.lattice.service.PatientService;
import com.lattice.util.ResponseHandler;

@RestController
@RequestMapping("patient")
public class PatientController {

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@PostMapping("register")
	ResponseEntity<Object> registerPatient(@Valid @RequestBody PatientDto patientDto) {
		return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "patient register successfully.",
				patientService.patientRegister(patientDto));
	}

	@GetMapping("getPatient/{id}")
	ResponseEntity<Object> getOnePatient(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success", patientService.getOnePatient(id));
	}

	@GetMapping("/getAllPatient")
	ResponseEntity<Object> getAllPatient() {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success", patientService.getAllPatient());
	}

	@PutMapping("/updatePatient/{id}")
	ResponseEntity<Object> updatePatient(@PathVariable("id") Integer id, @RequestBody PatientDto patientDto) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "patient updated successfully",
				patientService.updatePatient(id, patientDto));
	}

	@DeleteMapping("/deletePatient/{id}")
	ResponseEntity<Object> deletePatient(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "patient deleted successfully.",
				patientService.deletePatient(id));
	}

}
