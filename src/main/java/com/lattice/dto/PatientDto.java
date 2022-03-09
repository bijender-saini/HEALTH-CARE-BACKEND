package com.lattice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class PatientDto{
	
    @NotEmpty(message = "Please enter the name")
    @Pattern(regexp = "^[A-Za-z]{3,}$", message = "name field should contain atleast 3 character")
	private String patientName;
    
    @NotEmpty(message = "Please enter the address")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]{10,}$", message = "Address field should contain atleast 10 character")
	private String patientAddress;
    
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-[$&+,:;=?@#|'<>-^*()%!]]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Please enter a valid email address")
    @NotEmpty(message = "Please enter the email")
    private String patientEmail;

    @Pattern(regexp = "^[9][1][0-9]{10}$", message = "Please enter a valid phone number")
    @NotEmpty(message = "Please enter the phone number")
	private String patientMobile;
    
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,15}$", message = "password must contain one upper character,one lower character, and anumber , max  length 14 and minimum  8")  
    @NotBlank(message = "Please enter the password")
	private String patientPassword;
	

}
