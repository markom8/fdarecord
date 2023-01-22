package com.assignment.fdarecord.domain;

import com.assignment.fdarecord.api.service.dto.FdaResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FdaRecordMapperServiceTest {

    private FdaRecordMapperService fdaRecordMapperService = new FdaRecordMapperService();

    @Test
    public void mapFromFdaResponseDTO() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inJson = getClass().getClassLoader().getResourceAsStream("drugsfda.json");
        FdaResponseDTO fdaResponseDTO = objectMapper.readValue(inJson, FdaResponseDTO.class);
        List<FdaRecordEntity> fdaRecordEntities = fdaRecordMapperService.mapFromFdaResponseDTO(fdaResponseDTO);
        String fdaRecordEntityExpected = "{\"applicationNumber\":\"ANDA076393\",\"manufacturerName\":\"WATSON LABS\",\"substanceName\":\"WATSON LABS\",\"productNumbers\":[\"001\"]}";
        Assert.assertEquals(fdaRecordEntityExpected, objectMapper.writeValueAsString(fdaRecordEntities.get(0)));
    }
}