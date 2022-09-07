package com.safetynet.webappAlerts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicalRecordsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	MedicalRecordsDAO mdao;
	@Autowired
	MedicalRecordsController mrc;

	@Test
	public void testGetMedicalRecords() throws Exception {
		mockMvc.perform(get("/medicalrecords")).andExpect(status().isOk());
	}

	@Test
	public void testGetMedicalRecordsByName() throws Exception {
		mockMvc.perform(get("/medicalrecords/John/Boyd")).andExpect(status().isOk());
	}

	@Test
	public void testDeleteMedicalRecordsByName() throws Exception {
		mockMvc.perform(delete("/medicalrecords/John/Boyd")).andExpect(status().isOk());
	}
}
