package com.lattice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class AppointmentDetails {

	@Id
	@GeneratedValue
	Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private Integer noOfSlots;
	private String details;
	private Double fee;
	@ManyToOne
	@JoinColumn(name="doctor_fk")
	private DoctorDetails doctorDetails=new DoctorDetails() ;

}
