package com.lattice.service;

import java.util.List;

import com.lattice.dto.PatientDto;
import com.lattice.entity.Patient;

public interface PatientService {

	Patient patientRegister(PatientDto patientDto);

	Patient getOnePatient(Integer id);

	List<Patient> getAllPatient();

	Integer updatePatient(Integer id, PatientDto patientDto);

	String deletePatient(Integer id);

}
