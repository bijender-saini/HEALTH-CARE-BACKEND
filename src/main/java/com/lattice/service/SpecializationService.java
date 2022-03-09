package com.lattice.service;

import java.util.List;
import java.util.Map;

import com.lattice.dto.SpecializationDto;
import com.lattice.entity.Specialization;

public interface SpecializationService {
	
	public Specialization registerSpecialization(SpecializationDto specializationDto);
	public List<Specialization> getAllSpecialization();
	
	public Map<Integer,String> getSpecializationIdAndName();

}
