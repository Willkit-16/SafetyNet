package com.safetynet.model;

public class MedicalRecords {

	private String firstName;

	private String lastName;

	private String birthDate;

	private String medications;

	private String allergies;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthDate() {
		return birthDate;
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
