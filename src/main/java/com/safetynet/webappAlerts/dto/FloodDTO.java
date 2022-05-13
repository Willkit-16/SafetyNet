package com.safetynet.webappAlerts.dto;

public class FloodDTO {
	String firstName;
	String lastName;
	String phone;
	Long age;
	String medications;
	String allergies;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getMedications() {
		return medications;
	}

	public void setMedications(String medications) {
		this.medications = medications;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "Flood DTO{" + firstName + "," + lastName + "," + phone + "," + age + "," + medications + "," + allergies
				+ '}';
	}
}
