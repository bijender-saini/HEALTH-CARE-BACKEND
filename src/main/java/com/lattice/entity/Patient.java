package com.lattice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Patient {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String patientName;
	private String patientAddress;
	private String patientEmail;
	private String patientMobile;
	private String patientPassword;
}
