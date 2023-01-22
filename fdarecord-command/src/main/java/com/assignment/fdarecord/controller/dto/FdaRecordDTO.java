package com.assignment.fdarecord.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Value
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FdaRecordDTO {
    @NotEmpty
    private String applicationNumber;
    private String manufacturerName;
    private String substanceName;
    private List<String> productNumbers;
}
