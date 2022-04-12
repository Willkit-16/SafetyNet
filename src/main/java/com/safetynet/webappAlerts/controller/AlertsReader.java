package com.safetynet.webappAlerts.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

@Repository
public class AlertsReader {
	@SuppressWarnings("unchecked")
	public void readDataFromJson() throws FileNotFoundException, IOException {
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("src/main/resources/data.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray listOfPerson = (JSONArray) jsonObject.get("persons");

			Iterator<JSONObject> iteratorPerson = listOfPerson.iterator();

			JSONArray listOfFirestation = (JSONArray) jsonObject.get("firestations");

			Iterator<JSONObject> iteratorFireStations = listOfFirestation.iterator();

			JSONArray listOfMedicalrecords = (JSONArray) jsonObject.get("medicalrecords");

			Iterator<JSONObject> iteratorMedicalRecords = listOfMedicalrecords.iterator();

			while (iteratorPerson.hasNext()) {
				JSONObject jPerson = iteratorPerson.next();
				Person person = new Person(jPerson.get("firstName").toString(), jPerson.get("lastName").toString(),
						jPerson.get("address").toString(), jPerson.get("city").toString(),
						jPerson.get("zip").toString(), jPerson.get("phone").toString(),
						jPerson.get("email").toString());
				Data.arrayPerson.add(person);
			}
			while (iteratorFireStations.hasNext()) {
				JSONObject jFS = iteratorFireStations.next();
				FireStation fireS = new FireStation(jFS.get("address").toString(), jFS.get("station").toString(),
						listOfFirestation);
				Data.arrayFS.add(fireS);
			}
			while (iteratorMedicalRecords.hasNext()) {
				JSONObject jMR = iteratorMedicalRecords.next();
				MedicalRecords medicalR = new MedicalRecords(jMR.get("firstName").toString(),
						jMR.get("lastName").toString(), jMR.get("birthdate").toString(),
						jMR.get("medications").toString(), jMR.get("allergies").toString());
				Data.arrayMR.add(medicalR);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
