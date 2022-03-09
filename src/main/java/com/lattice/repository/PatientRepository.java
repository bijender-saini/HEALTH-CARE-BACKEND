package com.lattice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lattice.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	

}
