package com.assignment.fdarecord.service;

import com.assignment.fdarecord.api.service.dto.FdaResponseDTO;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;


public class FdaApiTest {

    @Test
    public void testDTO() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.fda.gov/drug/drugsfda.json";
        FdaResponseDTO result = restTemplate.getForObject(uri, FdaResponseDTO.class);
        System.out.println();
    }




}