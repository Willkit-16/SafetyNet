package com.safetynet.model;

import lombok.Data;

@Data
public class FireStations {

	private String address;

	private int stationNumber;

	public FireStations() {
	}

	public FireStations(String address, int stationNumber) {
		this.address = address;
		this.stationNumber = stationNumber;
	}

	@Override
	public String toString() {
		return "Firestations {" + address + "," + stationNumber + '}';
	}
}