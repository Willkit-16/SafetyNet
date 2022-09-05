package com.safetynet.webappAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.FireStation;

@Repository
public class FireStationDAO {

	public FireStation addFireStation(FireStation fr) {
		Data.getArrayFS().add(fr);
		return fr;
	}

	public List<FireStation> getFireStations() {
		return Data.getArrayFS();
	}

	public FireStation findFSByStationAndAddress(String station, String address) {
		for (FireStation f : Data.getArrayFS()) {
			if (f.station.equals(station) && f.address.equals(address)) {
				return f;
			}
		}
		return null;
	}

	public boolean deleteFSByStationAndAddress(String station, String address) {
		for (FireStation f : Data.getArrayFS()) {
			if (f.station.equals(station) && f.address.equals(address)) {
				return Data.getArrayFS().remove(f);
			}
		}
		return false;
	}

	public FireStation updateFireStation(String station, String address) {
		for (FireStation f : Data.getArrayFS())
			if (f.address.equals(address)) {
				f.setStation(station);
				return f;
			}
		return null;
	}

}
