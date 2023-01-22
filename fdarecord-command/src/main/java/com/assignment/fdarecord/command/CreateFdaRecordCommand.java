package com.assignment.fdarecord.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFdaRecordCommand {

    @TargetAggregateIdentifier
    private String applicationNumber;
    private String manufacturerName;
    private String substanceName;
    private List<String> productNumbers = new ArrayList<>();
}
