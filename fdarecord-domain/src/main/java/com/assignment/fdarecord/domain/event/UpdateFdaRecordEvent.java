package com.assignment.fdarecord.domain.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateFdaRecordEvent extends FdaRecordEvent {
    private String manufacturerName;
    private String substanceName;
    private List<String> productNumbers;

    @Builder
    public UpdateFdaRecordEvent(String applicationNumber, String manufacturerName, String substanceName, List<String> productNumbers) {
        super(applicationNumber);
        this.manufacturerName = manufacturerName;
        this.substanceName = substanceName;
        this.productNumbers = productNumbers;
    }
}
