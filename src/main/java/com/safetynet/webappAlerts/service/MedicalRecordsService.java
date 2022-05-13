package com.safetynet.webappAlerts.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webappAlerts.dao.FireStationDAO;
import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.dto.ChildAlertDTO;
import com.safetynet.webappAlerts.dto.ChildAlertListDTO;
import com.safetynet.webappAlerts.dto.FireDTO;
import com.safetynet.webappAlerts.dto.FireListDTO;
import com.safetynet.webappAlerts.dto.FloodDTO;
import com.safetynet.webappAlerts.dto.FloodListDTO;
import com.safetynet.webappAlerts.dto.PersonInfoListDTO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

@Service
public class MedicalRecordsService {
	@Autowired
	MedicalRecordsDAO mrdao;
	@Autowired
	PersonDAO pdao;
	@Autowired
	FireStationDAO fdao;
	@Autowired
	FireStationService fss;
	@Autowired
	PersonService ps;

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
				listOfChildrenByAddress = ps.findPrByAddress(personsAddress);
			}

			for (MedicalRecords m : mrdao.getMedicalRecords()) {
				if (listOfChildrenByAddress.contains(m.getFirstName())) {
					LocalDate dEnd = LocalDate.now();
					age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);
					ChildAlertDTO ca = new ChildAlertDTO();

					if (age <= 18) {
						ca.setFirstName(m.getFirstName());
						ca.setLastName(m.getLastName());
						ca.setAge(age);
						cal.getListOfChildren().add(ca);
					} else {
						return null;
					}

				}

			}
		}
		return cal;

	}

	public FireListDTO listByAddress(String personsAddress) {
		List<String> listOfPersonByAddress = new ArrayList<String>();
		long age = 0;
		FireListDTO fl = new FireListDTO();
		FireDTO fdto = new FireDTO();

		for (Person p : pdao.getPersons()) {
			if (p.getAddress().equals(personsAddress)) {
				listOfPersonByAddress.add(p.getFirstName());
				listOfPersonByAddress.add(p.getLastName());
				listOfPersonByAddress.add(p.getPhone());

				fdto.setPhone(p.getPhone());

			}
		}

		for (FireStation f : fdao.getFireStations()) {
			if (f.getAddress().equals(personsAddress)) {
				listOfPersonByAddress.add(f.getAddress());

				fdto.setStation(f.getStation());

			}
		}

		for (MedicalRecords m : mrdao.getMedicalRecords()) {
			if (listOfPersonByAddress.contains(m.getLastName())) {
				LocalDate dEnd = LocalDate.now();
				age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);
				listOfPersonByAddress.add(m.getAllergies());
				listOfPersonByAddress.add(m.getMedications());

				fdto.setFirstName(m.getFirstName());
				fdto.setLastName(m.getLastName());
				fdto.setAge(age);
				fdto.setMedications(m.getMedications());
				fdto.setAllergies(m.getAllergies());

				fl.getListOfPersonByAddress().add(fdto);
			}

			return fl;
		}

		return null;
	}

	public FloodListDTO familyByStation(String station) {
		List<String> listAddressByNumber = new ArrayList<String>();
		FloodListDTO fldto = new FloodListDTO();
		FloodDTO fdto = new FloodDTO();
		long age = 0;
		for (FireStation f : fdao.getFireStations()) {
			if (f.getStation().equals(station)) {
				listAddressByNumber = fss.findFSByNumber(station);
			}
		}

		for (MedicalRecords m : mrdao.getMedicalRecords()) {
			if (listAddressByNumber.contains(m.getFirstName())) {

				LocalDate dEnd = LocalDate.now();
				age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);
				fdto.setFirstName(m.getFirstName());
				fdto.setLastName(m.getLastName());
				fdto.setAge(age);
				fdto.setMedications(m.getMedications());
				fdto.setAllergies(m.getAllergies());
			}
			for (Person p : pdao.getPersons()) {
				if (listAddressByNumber.contains(p.getFirstName())) {
					fdto.setPhone(p.getPhone());
					fldto.getFamilyByStation().add(fdto);
				}
			}

		}
		return fldto;
	}

	public PersonInfoListDTO personInfo(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
