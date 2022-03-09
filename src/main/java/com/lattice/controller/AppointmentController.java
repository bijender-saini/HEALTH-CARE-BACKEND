package com.lattice.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.lattice.dto.AppointmentDetailsDto;
import com.lattice.service.AppointmentService;
import com.lattice.service.DoctorService;
import com.lattice.util.ResponseHandler;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService doctorService;

	@PostMapping("/register")
	ResponseEntity<Object> registerAppointment(@RequestBody AppointmentDetailsDto appointmentDetailsDto) {
		return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "appointment registered successfully.",
				appointmentService.registerAppointment(appointmentDetailsDto));
	}

	@GetMapping("/getAllAppointment")
	ResponseEntity<Object> getAllAppointment() {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success", appointmentService.getAllAppointment());
	}

	@GetMapping("/getAppointment/{id}")
	ResponseEntity<Object> getAppointment(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success",
				appointmentService.getOneAppointment(id));
	}

	@PutMapping("/updateAppointment/{id}")
	ResponseEntity<Integer> updateAppointment(@PathVariable("id") Integer id,
			@RequestBody AppointmentDetailsDto appointmentDetailsDto) {
		return new ResponseEntity<Integer>(appointmentService.updateAppointment(id, appointmentDetailsDto),
				HttpStatus.OK);

	}

	@DeleteMapping("/deleteAppointment/{id}")
	ResponseEntity<String> deleteAppointment(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(appointmentService.deleteAppointment(id), HttpStatus.OK);

	}
	
	@GetMapping("/getDoctorIdAndName")
	ResponseEntity<Object>getDoctorIdAndName(){
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success",doctorService.getDoctorNameAndId());
		
	}
}
