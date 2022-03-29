package com.safetynet.webappAlerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;
import com.safetynet.webappAlerts.model.MedicalRecords;

@Service
public class MedicalRecordsService {
	@Autowired
	MedicalRecordsDAO mr;

	public List<MedicalRecords> getMedicalRecords() {
		return mr.getMedicalRecords();
	}

	public MedicalRecords findMRByFirstAndLastName(String firstName, String lastName) {
		return mr.findMRByFirstNameAndLastName(firstName, lastName);
	}

	public boolean deleteMRByFirstAndLastName(String firstName, String lastName) {
		return mr.deleteMRByFirstAndLastName(firstName, lastName);

	}
}
