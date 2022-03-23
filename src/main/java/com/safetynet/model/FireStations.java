package com.safetynet.model;

import lombok.Data;

@Data
public class FireStations {

	private String address;

	private String stationNumber;

	public FireStations() {
	}

	public FireStations(String address, String stationNumber) {
		this.address = address;
		this.stationNumber = stationNumber;
	}

	@Override
	public String toString() {
		return "Firestations {" + address + "," + stationNumber + '}';
	}
}