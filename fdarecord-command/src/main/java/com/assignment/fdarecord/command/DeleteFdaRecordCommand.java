package com.assignment.fdarecord.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DeleteFdaRecordCommand {
    @TargetAggregateIdentifier
    private String applicationNumber;
    private String manufacturerName;
    private String substanceName;
    private List<String> productNumbers;
}
