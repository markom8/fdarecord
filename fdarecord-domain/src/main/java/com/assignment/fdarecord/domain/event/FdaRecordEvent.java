package com.assignment.fdarecord.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class FdaRecordEvent {
    @JsonProperty("applicationNumber")
    private String applicationNumber;

    public FdaRecordEvent(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public FdaRecordEvent() {
    }


}
