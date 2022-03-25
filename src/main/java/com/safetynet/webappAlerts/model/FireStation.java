package com.safetynet.webappAlerts.model;

import lombok.Data;

@Data
public class FireStation {

	private String address;

	private String stationNumber;

	public FireStation() {
	}

	public FireStation(String address, String stationNumber) {
		this.address = address;
		this.stationNumber = stationNumber;
	}

	@Override
	public String toString() {
		return "Firestations {" + address + "," + stationNumber + '}';
	}
}