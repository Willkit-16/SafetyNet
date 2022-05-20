package com.safetynet.webappAlerts.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(controllers = MedicalRecordsController.class)
public class MedicalRecordsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	MedicalRecordsController mrc;

	@Test
	public void testGetMedicalRecords() throws Exception {
		mockMvc.perform(get("/medicalrecords")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].firstName", is("John")));
	}
}
