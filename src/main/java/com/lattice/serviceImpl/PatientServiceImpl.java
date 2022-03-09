package com.lattice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lattice.dto.PatientDto;
import com.lattice.entity.Patient;
import com.lattice.exception.DataNotFoundException;
import com.lattice.repository.PatientRepository;
import com.lattice.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient patientRegister(PatientDto patientDto) {
		LOGGER.info("patient registration form {} ", patientDto);
		Patient patient = new Patient();
		patient.setPatientName(patientDto.getPatientName());
		patient.setPatientPassword(patientDto.getPatientPassword());
		patient.setPatientEmail(patientDto.getPatientEmail());
		patient.setPatientMobile(patientDto.getPatientMobile());
		patient.setPatientAddress(patientDto.getPatientAddress());
		Patient savedPatient = patientRepository.save(patient);
		LOGGER.info("After save user is --> {}", savedPatient);
		return savedPatient;
	}

	@Override
	public List<Patient> getAllPatient() {

		List<Patient> patientList = patientRepository.findAll();
		LOGGER.info("fetch all patient list is --> {}", patientList);
		if (CollectionUtils.isEmpty(patientList)) {
			throw new DataNotFoundException("data not found");
		}
		return patientList;
	}

	@Override
	public Patient getOnePatient(Integer id) {

		Optional<Patient> findById = patientRepository.findById(id);
		if (!findById.isPresent()) {
			throw new DataNotFoundException("data not found with given id :" + id);

		}

		return findById.get();
	}

	@Override
	public Integer updatePatient(Integer id, PatientDto patientDto) {

		Patient Patient = getOnePatient(id);
		Patient.setPatientName(patientDto.getPatientName());
		Patient.setPatientPassword(patientDto.getPatientPassword());
		Patient.setPatientEmail(patientDto.getPatientEmail());
		Patient.setPatientMobile(patientDto.getPatientMobile());
		Patient.setPatientAddress(patientDto.getPatientAddress());
		return patientRepository.save(Patient).getId();

	}

	@Override
	public String deletePatient(Integer id) {
		if (!patientRepository.existsById(id)) {
			throw new DataNotFoundException("data not found with given id :" + id);
		}
		patientRepository.deleteById(id);
		return "patient is deleted successfully with given id :" + id;
	}

}
