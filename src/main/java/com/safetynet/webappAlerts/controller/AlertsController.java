package com.safetynet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertsController {

	@GetMapping("/Person")
	public String listOfPerson() {
		return "Liste de Personne";
	}

}