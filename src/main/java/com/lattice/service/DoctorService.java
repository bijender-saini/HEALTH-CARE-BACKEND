package com.lattice.service;

import java.util.List;
import java.util.Map;

import com.lattice.dto.DoctorDetailsDto;
import com.lattice.entity.DoctorDetails;

public interface DoctorService {
	
	public DoctorDetails saveDoctor(DoctorDetailsDto doctorDetailsDto);
	public List<DoctorDetails> deleteDoctor(Integer id);
	public List<DoctorDetails> fetchAllDoctorDetails() ;
	public DoctorDetails getDoctorDetails(Integer id);
	public DoctorDetails updateDoctorDetails(DoctorDetailsDto doctorDetailsDto, Integer id);
	
	public Map<Integer,String> getDoctorNameAndId();
}
