package com.lattice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lattice.entity.AppointmentDetails;

public interface AppointmentRepository extends JpaRepository<AppointmentDetails, Integer> {

	@Query("from AppointmentDetails order by date asc")
	List<AppointmentDetails> getAppointmentList();
}
