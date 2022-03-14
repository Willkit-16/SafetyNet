package com.safetynet.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

@Repository
public class AlertsReader {
	@SuppressWarnings("unchecked")
	public void readDataFromJson() throws FileNotFoundException, IOException {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("src/main/resources/data.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray listOfPersons = (JSONArray) jsonObject.get("persons");

			Iterator<JSONObject> iterator = listOfPersons.iterator();

			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			Object obj = parser.parse(new FileReader("src/main/resources/data.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray listOfFirestation = (JSONArray) jsonObject.get("firestations");

			Iterator<JSONObject> iterator = listOfFirestation.iterator();

			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			Object obj = parser.parse(new FileReader("src/main/resources/data.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray listOfMedicalrecords = (JSONArray) jsonObject.get("medicalrecords");

			Iterator<JSONObject> iterator = listOfMedicalrecords.iterator();

			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
