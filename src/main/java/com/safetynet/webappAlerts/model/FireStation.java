package com.safetynet.webappAlerts.model;

import lombok.Data;

@Data
public class FireStation {

	public String address;

	public String station;

	public FireStation() {
	}

	public FireStation(String address, String station) {

		this.address = address;

		this.station = station;

	}

	@Override
	public String toString() {

		return "Firestations {" + address + "," + station + '}';
	}
}