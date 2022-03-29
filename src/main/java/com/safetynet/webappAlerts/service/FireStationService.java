package com.safetynet.webappAlerts.service;

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

	public FireStation findFSByStationAndAddress(String stationNumber, String address) {
		return fdao.findFSByStationAndAddress(stationNumber, address);
	}

	public FireStation deleteFSByStationAndAddress(String stationNumber, String address) {
		return fdao.deleteFSByStationAndAddress(stationNumber, address);

	}
}
