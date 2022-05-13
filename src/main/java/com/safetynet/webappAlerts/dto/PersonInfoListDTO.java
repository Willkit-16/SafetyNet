package com.safetynet.webappAlerts.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonInfoListDTO {

	List<PersonInfoDTO> personInfoList = new ArrayList<PersonInfoDTO>();

	public List<PersonInfoDTO> getPersonInfoList() {
		return personInfoList;
	}

	public void setPersonInfoList(List<PersonInfoDTO> personInfoList) {
		this.personInfoList = personInfoList;
	}
}
