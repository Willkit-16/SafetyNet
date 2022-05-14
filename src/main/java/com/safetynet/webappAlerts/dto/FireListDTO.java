package com.safetynet.webappAlerts.dto;

import java.util.ArrayList;
import java.util.List;

public class FireListDTO {

	List<FireDTO> listOfPersonByAddress = new ArrayList<FireDTO>();
	String stationNumber;

	public String getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}

	public List<FireDTO> getListOfPersonByAddress() {
		return listOfPersonByAddress;
	}

	public void setListOfPersonByAddress(List<FireDTO> listOfPersonByAddress) {
		this.listOfPersonByAddress = listOfPersonByAddress;
	}
}
