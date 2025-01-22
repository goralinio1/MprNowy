package com.example.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class CarApiService {

    private final RestTemplate restTemplate;

    @Value("${api.ninjas.key}")
    private String apiKey;

    public CarApiService() {
        restTemplate = new RestTemplate();
    }

    public List<Map<String, Object>> fetchAllCarMakers() {
        String apiUrl = "https://api.api-ninjas.com/v1/carmakes";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Map[].class);

        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        }

        return Collections.emptyList();
    }

    public List<Map<String, Object>> fetchCarDataByBrandAndYear(String brand, int year) {
        String apiUrl = "https://api.api-ninjas.com/v1/cars?make=" + brand + "&year=" + year;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Map[].class);

        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        }

        return Collections.emptyList();
    }
}
