package com.safetynet.webappAlerts.dto;

import java.util.ArrayList;
import java.util.List;

public class ChildAlertListDTO {

	List<ChildAlertDTO> listOfChildren = new ArrayList<ChildAlertDTO>();

	public List<ChildAlertDTO> getListOfChildren() {
		return listOfChildren;
	}

	public void setListOfChildren(List<ChildAlertDTO> listOfChildren) {
		this.listOfChildren = listOfChildren;
	}
}
