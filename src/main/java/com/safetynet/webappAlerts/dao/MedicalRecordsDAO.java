package com.safetynet.webappAlerts.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.MedicalRecords;

@Repository
public class MedicalRecordsDAO {

	public List<MedicalRecords> getMedicalRecords() {
		return Data.getArrayMR();
	}

	public MedicalRecords findMRByFirstNameAndLastName(String firstName, String lastName) {
		for (MedicalRecords m : Data.getArrayMR()) {
			if (m.firstName.equals(firstName) && m.lastName.equals(lastName)) {
				return m;
			}
		}
		return null;
	}

	public boolean deleteMRByFirstAndLastName(String firstName, String lastName) {
		for (MedicalRecords m : Data.getArrayMR()) {
			if (m.firstName.equals(firstName) && m.lastName.equals(lastName)) {
				return Data.getArrayMR().remove(m);
			}
		}
		return false;
	}

	public MedicalRecords addMedicalRecords(MedicalRecords mr) {
		Data.getArrayMR().add(mr);
		return mr;
	}

	public MedicalRecords updateMR(String firstName, String lastName, LocalDate birthDate, String medications,
			String allergies) {
		for (MedicalRecords m : Data.getArrayMR()) {
			if (m.firstName.equals(firstName) && m.lastName.equals(lastName)) {
				m.setBirthDate(birthDate);
				m.setAllergies(allergies);
				m.setMedications(medications);
				return m;
			}
		}
		return null;
	}
}
