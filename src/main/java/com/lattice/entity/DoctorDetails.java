package com.lattice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class DoctorDetails {

	@Id
	@GeneratedValue
	private Integer doctorId;
	private String name;
	private String emailId;
	private String address;
	private String mobile;
	private String gender;
	private String note;

	@OneToOne
	@JoinColumn(name = "specialization_fk")
	private Specialization specialization = new Specialization();

}
