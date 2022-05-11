package com.safetynet.webappAlerts.dto;

public class ChildAlertDTO {

	String firstName;
	String lastName;
	Long age;

	public Long getBirthDate() {
		return age;
	}

	public void setBirthDate(Long birthDate) {
		this.age = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Children {" + firstName + "," + lastName + "," + age + '}';
	}
}
