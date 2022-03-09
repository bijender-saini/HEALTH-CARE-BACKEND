package com.lattice;

import java.util.ArrayList;
import java.util.List;

import com.lattice.dto.PatientDto;
import com.lattice.entity.Patient;

public class TestPatientHelper {

	static List<Patient> buildPatientList() {

		Patient p = new Patient();
		p.setId(1);
		p.setPatientName("Radha");
		p.setPatientEmail("abc@gmail.com");
		p.setPatientMobile("918567894534");
		p.setPatientAddress("Sohna Gurgaon");
		p.setPatientPassword("Hello19Abc");

		ArrayList<Patient> al = new ArrayList<>();
		al.add(p);
		return al;

	}

	static Patient	buildPatient() {
		Patient p = new Patient();
//		p.setId(1);
		p.setPatientName("Radha");
		p.setPatientEmail("abc@gmail.com");
		p.setPatientMobile("918567894534");
		p.setPatientAddress("Sohna Gurgaon");
		p.setPatientPassword("Hello19Abc");
		return p;
	}
	
	static PatientDto	buildPatientDto() {
		PatientDto p = new PatientDto();
//		p.setId(1);
		p.setPatientName("Radha");
		p.setPatientEmail("abc@gmail.com");
		p.setPatientMobile("918567894534");
		p.setPatientAddress("Sohna Gurgaon");
		p.setPatientPassword("Hello19Abc");
		return p;
	}
}
