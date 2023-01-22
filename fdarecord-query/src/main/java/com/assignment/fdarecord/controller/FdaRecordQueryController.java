package com.assignment.fdarecord.controller;


import com.assignment.fdarecord.api.exception.FdaApiQueryException;
import com.assignment.fdarecord.api.exception.FdaApiSearchException;
import com.assignment.fdarecord.api.service.FdaApi;
import com.assignment.fdarecord.api.service.dto.FdaResponseDTO;
import com.assignment.fdarecord.domain.FdaRecordEntity;
import com.assignment.fdarecord.domain.event.FdaRecordEvent;
import com.assignment.fdarecord.service.FdaRecordQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/fda")
@AllArgsConstructor
public class FdaRecordQueryController {

    private final FdaApi fdaApi;
    private final FdaRecordQueryService fdaRecordQueryService;


    @GetMapping(value="search_api_records")
    public FdaResponseDTO searchApiRecords(@RequestParam(value = "page_no") @Min(1) Integer pageNo,
                                   @RequestParam(value = "page_size") @Min(1) Integer pageSize,
                                   @RequestParam(value = "manufacturer_name", required = false) String manufacturerName,
                                   @RequestParam(value = "brand_name", required = false) String brandName,
                                   @RequestParam(value = "exact", required = false) Boolean exact
    ) throws FdaApiSearchException, FdaApiQueryException {
        return this.fdaApi.searchFdaApi(manufacturerName, brandName, exact, pageNo, pageSize);
    }

    @GetMapping(value="query_api_records")
    public FdaResponseDTO queryApiRecords(@RequestParam(value = "page_no", required = false) @Min(1) Integer pageNo,
                                   @RequestParam(value = "page_size", required = false) @Min(1) Integer pageSize,
                                   @RequestParam(value = "search_param_name", required = false) String searchParamName,
                                   @RequestParam(value = "search_param_value", required = false) String searchParamValue,
                                   @RequestParam(value = "count_param_name", required = false) String countParamName
    ) throws FdaApiQueryException {
        return this.fdaApi.queryFdaApi(searchParamName, searchParamValue, countParamName,  pageNo, pageSize);
    }

    @GetMapping("/local_api_records/{applicationNumber}")
    public Optional<FdaRecordEntity> findById(@PathVariable("applicationNumber") String applicationNumber) {
        return this.fdaRecordQueryService.findById(applicationNumber);
    }

    @GetMapping(value="/local_api_records")
    public List<FdaRecordEntity> localApiRecords() {
        return this.fdaRecordQueryService.getAllStoredFdaRecordEntries();
    }

    @GetMapping("/{applicationNumber}/events")
    public List<FdaRecordEvent> listEventsForAccount(@PathVariable(value = "applicationNumber") String applicationNumber) {

        return (List<FdaRecordEvent>) this.fdaRecordQueryService.listEventsForRecord(applicationNumber);
    }
}
