package com.safetynet.webappAlerts.model;

public class FireStation {

	public String address;
	public String station;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public FireStation() {
	}

	public FireStation(String address, String station) {

		this.address = address;

		this.station = station;

	}

}