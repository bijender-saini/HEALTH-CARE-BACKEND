package com.lattice.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lattice.dto.AppointmentDetailsDto;
import com.lattice.entity.AppointmentDetails;
import com.lattice.entity.DoctorDetails;
import com.lattice.exception.DataNotFoundException;
import com.lattice.repository.AppointmentRepository;
import com.lattice.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public AppointmentDetails registerAppointment(AppointmentDetailsDto appointmentDetailsDto) {

		AppointmentDetails appointmentDetails = new AppointmentDetails();
		appointmentDetails.setDate(appointmentDetailsDto.getDate());
		appointmentDetails.setNoOfSlots(appointmentDetailsDto.getNoOfSlots());
		appointmentDetails.setFee(appointmentDetailsDto.getFee());
		appointmentDetails.setDetails(appointmentDetailsDto.getDetails());

		DoctorDetails doctorDetails = appointmentDetails.getDoctorDetails();
		doctorDetails.setDoctorId(appointmentDetailsDto.getDoctorId());
		return appointmentRepository.save(appointmentDetails);
	}

	@Override
	public List<AppointmentDetails> getAllAppointment() {
//		List<AppointmentDetails> appointmentList = appointmentRepository.findAll();
		List<AppointmentDetails> appointmentList =appointmentRepository.getAppointmentList();
		if (CollectionUtils.isEmpty(appointmentList)) {
			throw new DataNotFoundException("data not found");
		}
//		  appointmentList.sort(Comparator.comparing(AppointmentDetails::getDate));
		return appointmentList;

	}

	@Override
	public AppointmentDetails getOneAppointment(Integer id) {
		Optional<AppointmentDetails> findById = appointmentRepository.findById(id);
		if (!findById.isPresent()) {
			throw new DataNotFoundException("data not found with given id : " + id);
		}
		return findById.get();
	}

	@Override
	public String deleteAppointment(Integer id) {
		if (!appointmentRepository.existsById(id)) {
			throw new DataNotFoundException("data not found");
		}
		appointmentRepository.deleteById(id);
		return "appointment deleted successfully.";
	}

	@Override
	public Integer updateAppointment(Integer id, AppointmentDetailsDto appointmentDetailsDto) {
		AppointmentDetails appointment = getOneAppointment(id);

		appointment.setDate(appointmentDetailsDto.getDate());
		appointment.setNoOfSlots(appointmentDetailsDto.getNoOfSlots());
		appointment.setFee(appointmentDetailsDto.getFee());
		appointment.setDetails(appointmentDetailsDto.getDetails());
		return appointmentRepository.save(appointment).getId();

	}

}
