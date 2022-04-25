package com.safetynet.webappAlerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webappAlerts.dao.FireStationDAO;
import com.safetynet.webappAlerts.model.FireStation;

@Service
public class FireStationService {

	@Autowired
	FireStationDAO fdao;

	public List<FireStation> getFireStations() {
		return fdao.getFireStations();

	}

	public FireStation findFSByStationAndAddress(String station, String address) {
		return fdao.findFSByStationAndAddress(station, address);
	}

	public List<String> findFSByNumber(String station) {
		List<String> listAddress = new ArrayList<String>();
		for (FireStation f : fdao.getFireStations()) {
			if (f.getStation().equals(station)) {
				listAddress.add(f.getAddress());
			}
		}
		return listAddress;
	}

	public boolean deleteFSByStationAndAddress(String station, String address) {
		return fdao.deleteFSByStationAndAddress(station, address);

	}

	public FireStation addFireStation(FireStation fr) {
		return fdao.addFireStation(fr);
	}

	public FireStation updateFireStation(String station, String address) {
		return fdao.updateFireStation(station, address);
	}

}
