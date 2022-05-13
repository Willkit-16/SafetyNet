package com.safetynet.webappAlerts.dto;

import java.util.ArrayList;
import java.util.List;

public class FloodListDTO {
	List<FloodDTO> familyByStation = new ArrayList<FloodDTO>();

	public List<FloodDTO> getFamilyByStation() {
		return familyByStation;
	}

	public void setFamilyByStation(List<FloodDTO> familyByStation) {
		this.familyByStation = familyByStation;
	}
}
