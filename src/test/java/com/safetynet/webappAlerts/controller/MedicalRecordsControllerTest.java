package com.safetynet.webappAlerts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MedicalRecordsControllerTest {

	@Autowired
	private MockMvc mockMvc;
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

//	@Test
//	public void testPutMedicalRecordsByName() throws Exception {
//		mockMvc.perform(put("/medicalrecords/Tenley/Boyd/2012-02-18/[]/[peanut]")).andExpect(status().isOk());
//	}

	@Test
	public void testDeleteMedicalRecordsByName() throws Exception {
		mockMvc.perform(delete("/medicalrecords/John/Boyd")).andExpect(status().isOk());
	}

//	@Test
//	public void addMedicalRecordTest_shouldReturnOk() throws Exception {
//		MedicalRecords mr = new MedicalRecords();
//		when(MedicalRecordsService.getMedicalRecords(anyLong())).thenReturn(mr);
//		when(MedicalRecordsService.addMedicalRecords(eq(mr), any())).thenReturn(new MedicalRecords());
//		mockMvc.perform(post("/medicalrecords").contentType(MediaType.APPLICATION_JSON).content("{}"))
//				.andExpect(status().isOk());
//	}
}
