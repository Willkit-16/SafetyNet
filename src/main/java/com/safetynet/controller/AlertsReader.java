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

			JSONArray listOfData = (JSONArray) jsonObject.get("data");

			Iterator<JSONObject> iterator = listOfData.iterator();

			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
