package com.lattice.service;

import java.util.List;

import com.lattice.dto.AppointmentDetailsDto;
import com.lattice.entity.AppointmentDetails;

public interface AppointmentService {

	
	public AppointmentDetails registerAppointment(AppointmentDetailsDto appointmentDetailsDto);
	
	public List<AppointmentDetails>getAllAppointment();
	
	public AppointmentDetails getOneAppointment(Integer id);
	
	public String  deleteAppointment(Integer id);
	
	public Integer updateAppointment(Integer id,AppointmentDetailsDto appointmentDetailsDto);
	
	
	
}
