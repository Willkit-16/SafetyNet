package com.safetynet.webappAlerts.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.dto.ChildAlertDTO;
import com.safetynet.webappAlerts.dto.ChildAlertListDTO;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

@Service
public class MedicalRecordsService {
	@Autowired
	MedicalRecordsDAO mrdao;
	@Autowired
	PersonDAO pdao;

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

	public MedicalRecords updateMR(String firstName, String lastName, LocalDate birthDate, String medications,
			String allergies) {
		return mrdao.updateMR(firstName, lastName, birthDate, medications, allergies);
	}

	public ChildAlertListDTO listOfChildren(String personsAddress) {
		List<String> listOfChildrenByAddress = new ArrayList<String>();
		long age = 0;
		ChildAlertListDTO cal = new ChildAlertListDTO();

		for (Person p : pdao.getPersons()) {
			if (p.getAddress().equals(personsAddress)) {
				listOfChildrenByAddress.add(p.getFirstName());
				listOfChildrenByAddress.add(p.getLastName());

			}
		}

		for (MedicalRecords m : mrdao.getMedicalRecords()) {
			if (listOfChildrenByAddress.contains(m.getLastName())) {
				LocalDate dEnd = LocalDate.now();
				age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);
				ChildAlertDTO ca = new ChildAlertDTO();
				ca.setFirstName(m.getFirstName());
				ca.setLastName(m.getLastName());
				ca.setBirthDate(age);
				cal.getListOfChildren().add(ca);
				System.out.println(age);
			}
			if (age <= 18) {
				return cal;
			}
		}
		return null;
	}

}
