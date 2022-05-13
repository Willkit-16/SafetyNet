package com.safetynet.webappAlerts.dto;

import lombok.Data;

@Data
public class ChildAlertDTO {

	String firstName;
	String lastName;
	Long age;

	public ChildAlertDTO() {

	}

	public ChildAlertDTO(String firstName, String lastName, Long age) {

		this.firstName = firstName;

		this.lastName = lastName;

		this.age = age;
	}

	@Override
	public String toString() {
		return "Children {" + firstName + "," + lastName + "," + age + '}';
	}
}
