package com.safetynet.webappAlerts.model;

public class Person {

	public String firstName;

	public String lastName;

	public String personsAddress;

	public String city;

	public String zip;

	public String phone;

	public String email;

	public Person() {
	}

	public Person(String firstName, String lastName, String personsAddress, String city, String zip, String phone,
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

}