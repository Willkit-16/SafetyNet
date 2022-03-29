package com.safetynet.webappAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.FireStation;

@Repository
public class FireStationDAO {

	public void addFireStation(FireStation fr) {
		Data.arrayFS.add(fr);
	}

	public List<FireStation> getFireStations() {
		return Data.arrayFS;
	}

	public FireStation findFSByStationAndAddress(String stationNumber, String address) {
		for (FireStation f : Data.arrayFS) {
			if (f.stationNumber.equals(stationNumber) && f.address.equals(address)) {
				return f;
			}
		}
		return null;
	}

	public boolean deleteFSByStationAndAddress(String stationNumber, String address) {
		for (FireStation f : Data.arrayFS) {
			if (f.stationNumber.equals(stationNumber) && f.address.equals(address)) {
				return Data.arrayFS.remove(f);
			}
		}
		return false;
	}
}
