package com.lattice.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.dto.DoctorDetailsDto;
import com.lattice.entity.DoctorDetails;
import com.lattice.entity.Specialization;
import com.lattice.exception.DataNotFoundException;
import com.lattice.repository.DoctorRepository;
import com.lattice.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorServiceImpl.class);

	@Autowired
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	public DoctorDetails saveDoctor(DoctorDetailsDto doctorDetailsDto) {
		LOGGER.info("doctor registration form {}", doctorDetailsDto);

		DoctorDetails doctorDetails = new DoctorDetails();

		doctorDetails.setName(doctorDetailsDto.getName());
		doctorDetails.setEmailId(doctorDetailsDto.getEmailId());
		doctorDetails.setAddress(doctorDetailsDto.getAddress());
		doctorDetails.setMobile(doctorDetailsDto.getMobile());
		doctorDetails.setNote(doctorDetailsDto.getNote());
		doctorDetails.setGender(doctorDetailsDto.getGender());

		Specialization specialization = doctorDetails.getSpecialization();
		specialization.setId(doctorDetailsDto.getSpecializationId());
		DoctorDetails savedDoctor = doctorRepository.save(doctorDetails);
		LOGGER.info("After doctor user is --> {}", savedDoctor);
		return savedDoctor;

	}

	public List<DoctorDetails> deleteDoctor(Integer id) {
		getDoctorDetails(id);
		doctorRepository.deleteById(id);
		return fetchAllDoctorDetails();
	}

	public List<DoctorDetails> fetchAllDoctorDetails() {
		List<DoctorDetails> findAll = doctorRepository.findAll();
		LOGGER.info("fetch all doctor list is --> {}", findAll);
		if (findAll.isEmpty()) {
			throw new DataNotFoundException("data does not exist ");
		}
		return findAll;
	}

	public DoctorDetails getDoctorDetails(Integer id) {
		Optional<DoctorDetails> findById = doctorRepository.findById(id);
		if (!findById.isPresent()) {
			throw new DataNotFoundException("data not exist with given id");
		}
		return findById.get();
	}

	public DoctorDetails updateDoctorDetails(DoctorDetailsDto doctorDetailsDto, Integer id) {
		DoctorDetails doctorDetails = getDoctorDetails(id);

		doctorDetails.setName(doctorDetailsDto.getName());
		doctorDetails.setEmailId(doctorDetailsDto.getEmailId());
		doctorDetails.setAddress(doctorDetailsDto.getAddress());
		doctorDetails.setMobile(doctorDetailsDto.getMobile());
		doctorDetails.setNote(doctorDetailsDto.getNote());
		doctorDetails.setGender(doctorDetailsDto.getGender());
		return doctorRepository.save(doctorDetails);

	}

	@Override
	public Map<Integer, String> getDoctorNameAndId() {
		List<Object[]> list = doctorRepository.getDoctorIdAndName();
//		Map<Integer, String> map = new LinkedHashMap<>();
//		for (Object[] ob : list) {
//			map.put((Integer) ob[0], (String) ob[1]);
//		}
//		return map;
		return list.stream().collect(Collectors.toMap(ob -> (Integer) ob[0], ob -> (String) ob[1]));

	}

}
