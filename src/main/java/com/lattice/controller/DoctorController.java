package com.lattice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.dto.DoctorDetailsDto;
import com.lattice.service.DoctorService;
import com.lattice.service.SpecializationService;
import com.lattice.util.ResponseHandler;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private SpecializationService specializationService;

	@PostMapping("/saveDoctor")
	public ResponseEntity<Object> savedoctorDetails(@RequestBody DoctorDetailsDto doctorDetailsDto) {
		return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "doctor created successfully",
				doctorService.saveDoctor(doctorDetailsDto));
	}

	@DeleteMapping("/deleteDoctor/{id}")
	public ResponseEntity<Object> deleteDoctorDetails(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "doctor deleted successfully",
				doctorService.deleteDoctor(id));
	}

	@GetMapping("/getAllDoctor")
	public ResponseEntity<Object> fetchAllDoctor() {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "doctor  fetch All details successfully",
				doctorService.fetchAllDoctorDetails());
	}

	@GetMapping("/getDoctor/{id}")
	public ResponseEntity<Object> getdoctorDetails(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "doctor daetils fetch successfully",
				doctorService.getDoctorDetails(id));
	}

	@GetMapping("/getSpecializationIdAndName")
	public ResponseEntity<Object> getSpecializationIdAndName() {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success",
				specializationService.getSpecializationIdAndName());
	}

}
