package com.lattice.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lattice.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Serializable> {

	@Query("select id , name from Specialization")
	List<Object[]> getSpecializationIdAndName();

}
