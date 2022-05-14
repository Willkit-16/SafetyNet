package com.safetynet.webappAlerts.dto;

import java.util.ArrayList;
import java.util.List;

public class ChildAlertListDTO {

	List<ChildAlertDTO> listOfChildren = new ArrayList<ChildAlertDTO>();

	List<String> foyer = new ArrayList<String>();

	public List<String> getFoyer() {
		return foyer;
	}

	public void setFoyer(List<String> foyer) {
		this.foyer = foyer;
	}

	public List<ChildAlertDTO> getListOfChildren() {
		return listOfChildren;
	}

	public void setListOfChildren(List<ChildAlertDTO> listOfChildren) {
		this.listOfChildren = listOfChildren;
	}
}
