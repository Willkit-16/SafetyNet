package com.safetynet.webappAlerts.dto;

import java.util.ArrayList;
import java.util.List;

public class PeopleByStationNumberListDTO {
	List<PeopleByStationNumberDTO> peopleList = new ArrayList<PeopleByStationNumberDTO>();
	int adult;
	int minor;

	public List<PeopleByStationNumberDTO> getPeopleList() {
		return peopleList;
	}

	public void setPeopleList(List<PeopleByStationNumberDTO> peopleList) {
		this.peopleList = peopleList;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getMinor() {
		return minor;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}
}
