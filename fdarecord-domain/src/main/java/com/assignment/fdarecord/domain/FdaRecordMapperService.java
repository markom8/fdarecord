package com.assignment.fdarecord.domain;

import com.assignment.fdarecord.api.service.dto.FdaResponseDTO;
import com.assignment.fdarecord.api.service.structure.Product;
import com.assignment.fdarecord.api.service.structure.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FdaRecordMapperService {
    public FdaRecordEntity mapFromResult(Result result) {
        FdaRecordEntity fdaRecordEntity = new FdaRecordEntity();
        fdaRecordEntity.setApplicationNumber(result.getApplicationNumber());
        fdaRecordEntity.setManufacturerName(result.getSponsorName());
        fdaRecordEntity.setSubstanceName(result.getSponsorName());
        fdaRecordEntity.setProductNumbers(result.getProducts().stream().map(Product::getProductNumber).collect(Collectors.toList()));
        return fdaRecordEntity;
    }

    public List<FdaRecordEntity> mapFromFdaResponseDTO(FdaResponseDTO fdaResponseDTO) {
        return fdaResponseDTO.getResults().stream().map(result -> mapFromResult(result)).collect(Collectors.toList());
    }
}
