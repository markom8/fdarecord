package com.assignment.fdarecord.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class FindFdaRecordQuery implements Serializable {
    @JsonProperty("applicationNumber")
    private String applicationNumber;

    public FindFdaRecordQuery() {
    }

    public FindFdaRecordQuery(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }
}
