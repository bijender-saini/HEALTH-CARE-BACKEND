package com.lattice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.lattice.entity.Patient;
import com.lattice.repository.PatientRepository;
import com.lattice.serviceImpl.PatientServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestPatientServiceImpl {

	@InjectMocks
	PatientServiceImpl patientService;

	@Mock
	private PatientRepository patientRepository;

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void builPatient() {

		when(patientRepository.save(TestPatientHelper.buildPatient())).thenReturn(TestPatientHelper.buildPatient());
		assertNotNull(patientService.patientRegister(TestPatientHelper.buildPatientDto()));
	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void fetchAllPatient() {

		when(patientRepository.findAll()).thenReturn(TestPatientHelper.buildPatientList());
		assertEquals(1, patientService.getAllPatient().size());
	}

	@Test
	public void fetchPatientById() {
		when(patientRepository.findById(1)).thenReturn(Optional.of(TestPatientHelper.buildPatient()));
		assertNotNull(patientService.getOnePatient(1));
	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void deleteTemplateTest() throws Exception {
		Patient buildPatient = TestPatientHelper.buildPatient();
		when(patientRepository.findById(1)).thenReturn(Optional.of(buildPatient));
		patientRepository.deleteById(1);
		verify(patientRepository, times(1)).deleteById(1);

	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void updatePatientTest() {
		when(patientRepository.findAll()).thenReturn(TestPatientHelper.buildPatientList());
		when(patientRepository.findById(1)).thenReturn(Optional.of(TestPatientHelper.buildPatient()));
		Patient buildPatient = TestPatientHelper.buildPatient();
		buildPatient.setId(1);
		buildPatient.setPatientName("Krishna");
		patientRepository.save(TestPatientHelper.buildPatient());
		verify(patientRepository, times(1)).save(TestPatientHelper.buildPatient());

	}
}
