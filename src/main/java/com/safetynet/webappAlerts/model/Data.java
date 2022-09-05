package com.safetynet.webappAlerts.model;

import java.util.ArrayList;

public class Data {

	private static ArrayList<Person> arrayPerson = new ArrayList<Person>();

	private static ArrayList<FireStation> arrayFS = new ArrayList<FireStation>();

	private static ArrayList<MedicalRecords> arrayMR = new ArrayList<MedicalRecords>();

	public static ArrayList<Person> getArrayPerson() {
		return arrayPerson;
	}

	public static void setArrayPerson(ArrayList<Person> arrayPerson) {
		Data.arrayPerson = arrayPerson;
	}

	public static ArrayList<FireStation> getArrayFS() {
		return arrayFS;
	}

	public static void setArrayFS(ArrayList<FireStation> arrayFS) {
		Data.arrayFS = arrayFS;
	}

	public static ArrayList<MedicalRecords> getArrayMR() {
		return arrayMR;
	}

	public static void setArrayMR(ArrayList<MedicalRecords> arrayMR) {
		Data.arrayMR = arrayMR;
	}

}
