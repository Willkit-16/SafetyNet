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

		// Recherche sur chq addresse, si personne mm addrr = dans list temporaire
		for (Person p : pdao.getPersons()) {
			if (p.getAddress().equals(personsAddress)) {
				listOfChildrenByAddress = ps.findPrByAd(personsAddress);
			}

			// ici chercher age et ajouter ds 2eme liste temporaire pr les - de18ans
			for (MedicalRecords m : mrdao.getMedicalRecords()) {
				if (listOfChildrenByAddress.contains(m.getLastName())) {
					LocalDate dEnd = LocalDate.now();
					age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);
					if (age <= 18) {
						if (m.getFirstName().equals(p.getFirstName()) && m.getLastName().equals(p.getLastName())) {
							ChildAlertDTO ca = new ChildAlertDTO();
							ca.setFirstName(m.getFirstName());
							ca.setLastName(m.getLastName());
							ca.setAge(age);
							cal.getListOfChildren().add(ca);
							cal.setFoyer(listOfChildrenByAddress);
						}
					}
				}
			}
		}

		// ajouter ds list dto ici ajout 18ans - et ttes les autres personnes y habitant
		// avec

		return cal;

	}

	public FireListDTO listByAddress(String personsAddress) {
		List<String> listOfPersonByAddress = new ArrayList<String>();
		long age = 0;
		FireListDTO fl = new FireListDTO();

		for (Person p : pdao.getPersons()) {
			if (p.getAddress().equals(personsAddress)) {
				listOfPersonByAddress = ps.findPrByAd(personsAddress);
			}

			for (MedicalRecords m : mrdao.getMedicalRecords()) {
				if (listOfPersonByAddress.contains(m.getLastName())) {
					LocalDate dEnd = LocalDate.now();
					age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);

					if (m.getFirstName().equals(p.getFirstName()) && m.getLastName().equals(p.getLastName())) {
						FireDTO fd = new FireDTO();
						fd.setFirstName(m.getFirstName());
						fd.setLastName(m.getLastName());
						fd.setAge(age);
						fd.setMedications(m.getMedications());
						fd.setAllergies(m.getAllergies());
						fd.setPhone(p.getPhone());
						fl.getListOfPersonByAddress().add(fd);
					}
				}
				for (FireStation f : fdao.getFireStations()) {
					if (personsAddress.equals(f.getAddress())) {
						fl.setStationNumber(f.getStation());
					}
				}
			}
		}

		return fl;
	}

	public FloodListDTO familyByStation(String station) {
		List<String> listAddressByNumber = new ArrayList<String>();
		FloodListDTO fldto = new FloodListDTO();
		long age = 0;
		for (FireStation f : fdao.getFireStations()) {
			if (f.getStation().equals(station)) {
				listAddressByNumber = fss.findFSByNumber(station);
			}
		}

		return fldto;
	}

	public PersonInfoListDTO personInfo(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
