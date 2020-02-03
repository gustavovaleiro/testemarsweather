package com.gustavovaleiro.testevaga.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavovaleiro.testevaga.model.SolResult;
import com.gustavovaleiro.testevaga.model.Temperature;

@Service
public class MarsWeatherService {

	
	public Temperature getAverageTemp(Integer solId) throws JsonMappingException, JsonProcessingException {
        ObjectMapper oMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        
        oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ResponseEntity<String> response
		  = restTemplate.getForEntity("https://api.nasa.gov/insight_weather/?api_key=Qlj3ELjpaW4apcylCTStr83jVPHejGq6DmTfjauh&feedtype=json&ver=1.0", String.class);
		 Map<String, Object> resultInMap = new ObjectMapper().readValue(response.getBody(), Map.class);
		
		List<String> keys = (List<String>) resultInMap.get("sol_keys");
		
		if(solId != null && keys.contains(String.valueOf(solId))) {
			SolResult sol = getSolInResult(String.valueOf(solId), oMapper, resultInMap);
			return new Temperature(sol.getAt().getAv());
		}else {

			List<SolResult> solResults = new ArrayList<SolResult>();
			for(String key: keys) {
				solResults.add(this.getSolInResult(key, oMapper, resultInMap));
			}
			double averageOfAll = solResults.stream().mapToDouble(sol -> sol.getAt().getAv()).average().orElse(0);
			return new Temperature(averageOfAll);
		}
	}

	private SolResult getSolInResult(String solId, ObjectMapper oMapper, Map<String, Object> resultInMap) {
		return oMapper.convertValue(resultInMap.get(solId),SolResult.class);
	}
	
}
