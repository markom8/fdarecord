package com.assignment.fdarecord.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.eventhandling.scheduling.ScheduleToken;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFdaRecordCommand {
    @TargetAggregateIdentifier
    private String applicationNumber;
    private String manufacturerName;
    private String substanceName;
    private List<String> productNumbers = new ArrayList<>();
}
