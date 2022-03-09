package com.lattice.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.dto.SpecializationDto;
import com.lattice.entity.Specialization;
import com.lattice.exception.DataNotFoundException;
import com.lattice.repository.SpecializationRepository;
import com.lattice.service.SpecializationService;

@Service
public class SpecializationServiceImpl implements SpecializationService {

	@Autowired
	private SpecializationRepository specializationRepository;

	@Override
	public Specialization registerSpecialization(SpecializationDto specializationDto) {
		Specialization specialization = new Specialization();
		specialization.setCode(specializationDto.getCode());
		specialization.setName(specializationDto.getName());
		specialization.setNote(specializationDto.getNote());

		return specializationRepository.save(specialization);
	}

	@Override
	public List<Specialization> getAllSpecialization() {

		List<Specialization> specializationList = specializationRepository.findAll();
		if (specializationList.isEmpty()) {
			throw new DataNotFoundException("data not found.");
		}
		return specializationList;
	}

	@Override
	public Map<Integer, String> getSpecializationIdAndName() {
		List<Object[]> list = specializationRepository.getSpecializationIdAndName();
		return list.stream().collect(Collectors.toMap(ob -> (Integer) ob[0], ob -> (String) ob[1]));
		
//		Map<Integer, String> map = new LinkedHashMap<>();
//		for (Object[] ob : list) {
//			map.put((Integer) ob[0], (String) ob[1]);
//		}
//		return map;
	}

}
