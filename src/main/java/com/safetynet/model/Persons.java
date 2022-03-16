package com.safetynet.model;

public class Persons {

	private String firstName;

	private String lastName;

	private String personsAddress;

	private String city;

	private String zip;

	private String phone;

	private String email;

	public Persons() {
	}

	public Persons(String firstName, String lastName, String personsAddress, String city, String zip, String phone,
			String email) {

		this.firstName = firstName;

		this.lastName = lastName;

		this.personsAddress = personsAddress;

		this.city = city;

		this.zip = zip;

		this.phone = phone;

		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return personsAddress;
	}

	public void setAddress(String personsAddress) {
		this.personsAddress = personsAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persons{" + firstName + "," + lastName + "," + personsAddress + "," + city + "," + zip + "," + phone
				+ "," + email + '}';
	}
}