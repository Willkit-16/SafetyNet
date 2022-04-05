package com.safetynet.webappAlerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;
import com.safetynet.webappAlerts.model.MedicalRecords;

@Service
public class MedicalRecordsService {
	@Autowired
	MedicalRecordsDAO mrdao;

	public List<MedicalRecords> getMedicalRecords() {
		return mrdao.getMedicalRecords();
	}

	public MedicalRecords findMRByFirstAndLastName(String firstName, String lastName) {
		return mrdao.findMRByFirstNameAndLastName(firstName, lastName);
	}

	public boolean deleteMRByFirstAndLastName(String firstName, String lastName) {
		return mrdao.deleteMRByFirstAndLastName(firstName, lastName);

	}

	public MedicalRecords addMedicalRecords(MedicalRecords mr) {
		return mrdao.addMedicalRecords(mr);
	}

	public MedicalRecords updateMR(String firstName, String lastName, String birthDate, String medications,
			String allergies) {
		return mrdao.updateMR(firstName, lastName, birthDate, medications, allergies);
	}

}
