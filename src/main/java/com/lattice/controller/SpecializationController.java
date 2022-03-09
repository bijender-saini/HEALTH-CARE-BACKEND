package com.lattice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.dto.SpecializationDto;
import com.lattice.service.SpecializationService;
import com.lattice.util.ResponseHandler;

@RestController
@RequestMapping("/specialization")
public class SpecializationController {

	@Autowired
	private SpecializationService specializationService;

	@PostMapping("/register")
	ResponseEntity<Object> registerSpecialization(@RequestBody SpecializationDto specializationDto) {
		return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "specialization register successfully",
				specializationService.registerSpecialization(specializationDto));
	}

	@GetMapping("/getAllSpecialization")
	ResponseEntity<Object> getAllSpecialization() {
//		Map<Integer, String> specializationIdAndName = specializationService.getSpecializationIdAndName();
//		System.out.println(specializationIdAndName.entrySet());
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success",
				specializationService.getAllSpecialization());

	
	}
}
