package com.safetynet.model;

import lombok.Data;

@Data
public class Firestations {

	private String address;

	private int stationId;

	@Override
	public String toString() {
		return "Firestations {" + address + "," + stationId + '}';
	}
}
