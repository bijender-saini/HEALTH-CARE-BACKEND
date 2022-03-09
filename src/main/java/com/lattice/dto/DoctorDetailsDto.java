package com.lattice.dto;

import lombok.Data;

@Data
public class DoctorDetailsDto {

	private String name;
	private String emailId;
	private String address;
	private String mobile;
	private String gender;
	private String note;
	private Integer specializationId;
}
