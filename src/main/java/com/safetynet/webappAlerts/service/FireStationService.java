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
import com.safetynet.webappAlerts.dto.PeopleByStationNumberDTO;
import com.safetynet.webappAlerts.dto.PeopleByStationNumberListDTO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class FireStationService.
 */
@Service
public class FireStationService {

	/** The fdao. */
	@Autowired
	FireStationDAO fdao;

	/** The pdao. */
	@Autowired
	PersonDAO pdao;

	/**
	 * Gets the fire stations.
	 *
	 * @return the fire stations
	 */
	public List<FireStation> getFireStations() {
		return fdao.getFireStations();

	}

	/**
	 * Find FS by station and address.
	 *
	 * @param station the station
	 * @param address the address
	 * @return the fire station
	 */
	public FireStation findFSByStationAndAddress(String station, String address) {
		return fdao.findFSByStationAndAddress(station, address);
	}

	/**
	 * Find FS by number.
	 *
	 * @param station the station
	 * @return the list
	 */
	public List<String> findFSByNumber(String station) {
		List<String> listAddress = new ArrayList<String>();
		for (FireStation f : fdao.getFireStations()) {
			if (f.getStation().equals(station)) {
				listAddress.add(f.getAddress());
			}
		}
		return listAddress;
	}

	/**
	 * Delete FS by station and address.
	 *
	 * @param station the station
	 * @param address the address
	 * @return true, if successful
	 */
	public boolean deleteFSByStationAndAddress(String station, String address) {
		return fdao.deleteFSByStationAndAddress(station, address);

	}

	/**
	 * Adds the fire station.
	 *
	 * @param fr the fr
	 * @return the fire station
	 */
	public FireStation addFireStation(FireStation fr) {
		return fdao.addFireStation(fr);
	}

	/**
	 * Update fire station.
	 *
	 * @param station the station
	 * @param address the address
	 * @return the fire station
	 */
	public FireStation updateFireStation(String station, String address) {
		return fdao.updateFireStation(station, address);
	}

	/**
	 * List of people.
	 *
	 * @param station the station
	 * @return the people by station number list DTO
	 */
	public PeopleByStationNumberListDTO listOfPeople(String station) {
		List<String> listAddressByNumber = new ArrayList<String>();
		PeopleByStationNumberListDTO pbsn = new PeopleByStationNumberListDTO();
		for (FireStation f : fdao.getFireStations()) {
			if (f.getStation().equals(station)) {
				listAddressByNumber = findFSByNumber(station);
			}
		}
		for (Person p : pdao.getPersons()) {
			if (listAddressByNumber.contains(p.getAddress())) {
				PeopleByStationNumberDTO pb = new PeopleByStationNumberDTO();
				pb.setFirstName(p.getFirstName());
				pb.setLastName(p.getLastName());
				pb.setAddress(p.getAddress());
				pb.setPhone(p.getPhone());
				pbsn.getPeopleList().add(pb);
				MedicalRecordsDAO mr = new MedicalRecordsDAO();

				for (MedicalRecords m : mr.getMedicalRecords()) {
					if (m.firstName.equals(p.firstName) && m.lastName.equals(p.lastName)) {
						LocalDate dEnd = LocalDate.now();
						if (ChronoUnit.YEARS.between(m.getBirthDate(), dEnd) <= 18) {
							pbsn.setMinor(pbsn.getMinor() + 1);
						} else {
							pbsn.setAdult(pbsn.getAdult() + 1);
							;
						}
					}
				}

			}

		}
		return pbsn;
	}

}
