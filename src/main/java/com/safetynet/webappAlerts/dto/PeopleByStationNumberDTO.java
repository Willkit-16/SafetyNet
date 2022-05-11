package com.safetynet.webappAlerts.dto;

import lombok.Data;

@Data
public class PeopleByStationNumberDTO {

	String firstName;
	String lastName;
	String address;
	String phone;

	public PeopleByStationNumberDTO() {

	}

	public PeopleByStationNumberDTO(String firstName, String lastName, String address, String phone) {

		this.firstName = firstName;

		this.lastName = lastName;

		this.address = address;

		this.phone = phone;

	}

	@Override
	public String toString() {
		return "People {" + firstName + "," + lastName + "," + address + "," + phone + '}';
	}
}
