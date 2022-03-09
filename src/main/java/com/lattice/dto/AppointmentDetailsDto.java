package com.lattice.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class AppointmentDetailsDto {

//	@Temporal(TemporalType.DATE)
	private Date date;
	private Integer noOfSlots;
	private String details;
	private Double fee;
	private Integer doctorId;
	

}
