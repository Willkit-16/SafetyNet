package com.safetynet.webappAlerts.model;

import java.util.List;

import lombok.Data;

@Data
public class FireStation {

	public List<String> address; // Faire une liste ici.

	public String stationNumber;

	public FireStation() {
	}

	public FireStation(List<String> address, String stationNumber) {
		this.address = address;
		this.stationNumber = stationNumber;

	}

	@Override
	public String toString() {
		return "Firestations {" + address + "," + stationNumber + '}';
	}
}