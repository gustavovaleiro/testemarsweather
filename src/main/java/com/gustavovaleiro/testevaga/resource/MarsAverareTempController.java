package com.gustavovaleiro.testevaga.resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gustavovaleiro.testevaga.model.Temperature;
import com.gustavovaleiro.testevaga.service.MarsWeatherService;

@RestController
@RequestMapping(value = "/nasa")
public class MarsAverareTempController {
	@Autowired
	private MarsWeatherService service;
	
	@GetMapping(value = "/temperature")
	public ResponseEntity<Temperature> findAllBy(
			@RequestParam(value = "sol", required = false) Integer sol) throws JsonMappingException, JsonProcessingException {
		
	
		return ResponseEntity.ok().body(this.service.getAverageTemp(sol));   
	}
}
