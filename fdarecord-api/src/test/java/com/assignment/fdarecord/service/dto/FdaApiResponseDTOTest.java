package com.assignment.fdarecord.service.dto;

import com.assignment.fdarecord.api.service.dto.FdaResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class FdaApiResponseDTOTest {
    @Test
    public void test() throws IOException {
        InputStream inJson = getClass().getClassLoader().getResourceAsStream("drugsfda.json");
        FdaResponseDTO fdaResponseDTO = new ObjectMapper().readValue(inJson, FdaResponseDTO.class);
        Assert.assertEquals("ANDA076393", fdaResponseDTO.getResults().get(0).getApplicationNumber());
    }

}