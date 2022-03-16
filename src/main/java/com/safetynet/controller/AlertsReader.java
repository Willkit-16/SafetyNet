package com.safetynet.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AlertsReader {
	@SuppressWarnings("unchecked")
	public void readDataFromJson() throws FileNotFoundException, IOException {
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("src/main/resources/data.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray listOfPersons = (JSONArray) jsonObject.get("persons");

			Iterator<JSONObject> iteratorPersons = listOfPersons.iterator();

			JSONArray listOfFirestation = (JSONArray) jsonObject.get("firestations");

			Iterator<JSONObject> iteratorFirestations = listOfFirestation.iterator();

			JSONArray listOfMedicalrecords = (JSONArray) jsonObject.get("medicalrecords");

			Iterator<JSONObject> iteratorMedicalrecords = listOfMedicalrecords.iterator();

			while (iteratorPersons.hasNext()) {
				System.out.println(iteratorPersons.next());
			}
			while (iteratorFirestations.hasNext()) {
				System.out.println(iteratorFirestations.next());
			}
			while (iteratorMedicalrecords.hasNext()) {
				System.out.println(iteratorMedicalrecords.next());
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
