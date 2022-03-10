package com.safetynet.model;

import lombok.Data;

@Data
public class FireStations {

	private String address;

	private int stationId;

	public FireStations() {
	}

	public FireStations(String address, int stationId) {
		this.address = address;
		this.stationId = stationId;
	}

	@Override
	public String toString() {
		return "Firestations {" + address + "," + stationId + '}';
	}
}