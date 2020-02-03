package com.gustavovaleiro.testevaga;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavovaleiro.testevaga.service.MarsWeatherService;

@SpringBootApplication
public class TestevagaApplication {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(TestevagaApplication.class, args);
		MarsWeatherService service = new MarsWeatherService();
		service.getAverageTemp(416);
	}

}
