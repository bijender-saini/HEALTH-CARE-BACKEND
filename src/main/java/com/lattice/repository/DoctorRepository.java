package com.lattice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lattice.entity.DoctorDetails;


public interface DoctorRepository extends JpaRepository<DoctorDetails, Integer> {
	
	@Query("select doctorId,name from DoctorDetails")
	List<Object[]>getDoctorIdAndName();

}
