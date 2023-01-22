package com.assignment.fdarecord.api.service;

import com.assignment.fdarecord.api.service.structure.Operation;
import com.assignment.fdarecord.api.exception.FdaApiQueryException;
import com.assignment.fdarecord.api.exception.FdaApiSearchException;
import com.assignment.fdarecord.api.service.dto.FdaResponseDTO;
import com.assignment.fdarecord.api.service.structure.OperationKey;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class FdaApi {
    private RestTemplate restTemplate = new RestTemplate();
    private static final String FDA_URL = "https://api.fda.gov/drug/drugsfda.json";

    public FdaResponseDTO searchFdaApi(String manufacturerName, String brandName, Boolean exact, Integer pageNo, Integer pageSize) throws FdaApiSearchException, FdaApiQueryException {
        if (!StringUtils.isEmpty(manufacturerName) && !StringUtils.isEmpty(brandName)) {
            throw new FdaApiSearchException();
        }
        if (!StringUtils.isEmpty(manufacturerName)) {
            return queryFdaApi(getOperationValue(OperationKey.MANUFACTURER_NAME.name, exact), manufacturerName, null, pageNo, pageSize);
        }
        return queryFdaApi(getOperationValue(OperationKey.BRAND_NAME.name, exact), manufacturerName, null, pageNo, pageSize);
    }

    public FdaResponseDTO queryFdaApi(String searchParamName, String searchParamValue, String countParamName, Integer pageNo, Integer pageSize) throws FdaApiQueryException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FDA_URL);
        Map<String, String> params = new HashMap<>();

        if (!StringUtils.isEmpty(searchParamName) && !StringUtils.isEmpty(searchParamValue)) {
            addOperationToSearchRequest(searchParamName, searchParamValue, params, false);
        }
        if (!StringUtils.isEmpty(countParamName)) {
            if (pageNo != null) {
                throw new FdaApiQueryException();
            }
            params.put(Operation.COUNT.name, countParamName);
        }
        addPaginationToFdaRequest(pageNo, pageSize, params);
        addParametersToURI(builder, params);

        return restTemplate.getForObject(builder.build().toUri(),
                FdaResponseDTO.class);
    }

    private void addParametersToURI(UriComponentsBuilder builder, Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
    }

    private void addOperationToSearchRequest(String operationKey, String name, Map<String, String> params, Boolean exact) {
        params.put(Operation.SEARCH.name, getOperationValue(operationKey, exact) + ":" + "\"" + name + "\"");
    }

    private String getOperationValue(String operationKey, Boolean exact) {
        if (exact != null && exact) {
            operationKey = operationKey + ".exact";
        }
        return operationKey;
    }

    private void addPaginationToFdaRequest(Integer pageNo, Integer pageSize, Map<String, String> params) {
        if (pageNo!= null && pageNo > 1) {
            params.put("skip", String.valueOf(((pageNo - 1) * pageSize)));
        }
        if (pageSize != null) {
            params.put("limit", pageSize.toString());
        }
    }
}
