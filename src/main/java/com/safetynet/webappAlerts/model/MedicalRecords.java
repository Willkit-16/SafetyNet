package com.safetynet.webappAlerts.model;

public class MedicalRecords {

	public String firstName;

	public String lastName;

	public String birthDate;

	public String medications;

	public String allergies;

	public MedicalRecords() {
	}

	public MedicalRecords(String firstName, String lastName, String birthDate, String medications, String allergies) {

		this.firstName = firstName;

		this.lastName = lastName;

		this.birthDate = birthDate;

		this.medications = medications;

		this.allergies = allergies;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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
		return "Medical Records{" + firstName + "," + lastName + "," + birthDate + "," + medications + "," + allergies
				+ '}';
	}
}
