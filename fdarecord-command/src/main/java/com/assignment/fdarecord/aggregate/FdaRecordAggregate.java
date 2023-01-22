package com.assignment.fdarecord.aggregate;

import com.assignment.fdarecord.command.CreateFdaRecordCommand;
import com.assignment.fdarecord.command.DeleteFdaRecordCommand;
import com.assignment.fdarecord.command.UpdateFdaRecordCommand;
import com.assignment.fdarecord.domain.event.CreateFdaRecordEvent;
import com.assignment.fdarecord.domain.event.DeleteFdaRecordEvent;
import com.assignment.fdarecord.domain.event.UpdateFdaRecordEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class FdaRecordAggregate {

    @AggregateIdentifier
    private String applicationNumber;
    private String manufacturerName;
    private String substanceName;
    private List<String> productNumbers;

    @CommandHandler
    public FdaRecordAggregate(CreateFdaRecordCommand command) {

        AggregateLifecycle.apply(
                new CreateFdaRecordEvent(
                        command.getApplicationNumber(),
                        command.getManufacturerName(),
                        command.getSubstanceName(),
                        command.getProductNumbers()
                )
        );
    }

    @EventSourcingHandler
    public void on(CreateFdaRecordEvent event) {
        this.applicationNumber = event.getApplicationNumber();
        this.manufacturerName = event.getManufacturerName();
        this.substanceName = event.getSubstanceName();
        this.productNumbers = event.getProductNumbers();
    }

    @CommandHandler
    public void handle(UpdateFdaRecordCommand command) {
        AggregateLifecycle.apply(
                new UpdateFdaRecordEvent(
                        command.getApplicationNumber(),
                        command.getManufacturerName(),
                        command.getSubstanceName(),
                        command.getProductNumbers()
                )
        );
    }

    @CommandHandler
    public void handle(DeleteFdaRecordCommand command) {
        AggregateLifecycle.apply(new DeleteFdaRecordEvent(command.getApplicationNumber(), null,null, null));
    }

    @EventSourcingHandler
    protected void on(DeleteFdaRecordEvent event) {
        AggregateLifecycle.markDeleted();
    }
}
