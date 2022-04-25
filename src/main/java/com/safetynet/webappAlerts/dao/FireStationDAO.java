package com.safetynet.webappAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.FireStation;

@Repository
public class FireStationDAO {

	public FireStation addFireStation(FireStation fr) {
		Data.arrayFS.add(fr);
		return fr;
	}

	public List<FireStation> getFireStations() {
		return Data.arrayFS;
	}

	public FireStation findFSByStationAndAddress(String station, String address) {
		for (FireStation f : Data.arrayFS) {
			if (f.station.equals(station) && f.address.equals(address)) {
				return f;
			}
		}
		return null;
	}

	public boolean deleteFSByStationAndAddress(String station, String address) {
		for (FireStation f : Data.arrayFS) {
			if (f.station.equals(station) && f.address.equals(address)) {
				return Data.arrayFS.remove(f);
			}
		}
		return false;
	}

	public FireStation updateFireStation(String station, String address) {
		for (FireStation f : Data.arrayFS)
			if (f.station.equals(station) && f.address.equals(address)) {
				f.setStation(station);
				return f;
			}
		return null;
	}

}
