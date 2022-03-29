package com.safetynet.webappAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.MedicalRecords;

@Repository
public class MedicalRecordsDAO {

	public List<MedicalRecords> getMedicalRecords() {
		return Data.arrayMR;
	}

	public void addMedicalRecords(MedicalRecords mr) {
		Data.arrayMR.add(mr);
	}

	public MedicalRecords findMRByFirstNameAndLastName(String firstName, String lastName) {
		for (MedicalRecords m : Data.arrayMR) {
			if (m.firstName.equals(firstName) && m.lastName.equals(lastName)) {
				return m;
			}
		}
		return null;
	}

	public boolean deleteMRByFirstAndLastName(String firstName, String lastName) {
		for (MedicalRecords m : Data.arrayMR) {
			if (m.firstName.equals(firstName) && m.lastName.equals(lastName)) {
				return Data.arrayMR.remove(m);
			}
		}
		return false;
	}
}
