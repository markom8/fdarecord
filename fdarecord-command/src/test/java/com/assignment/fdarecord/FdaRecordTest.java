package com.assignment.fdarecord;


import com.assignment.fdarecord.aggregate.FdaRecordAggregate;
import com.assignment.fdarecord.command.CreateFdaRecordCommand;
import com.assignment.fdarecord.command.DeleteFdaRecordCommand;
import com.assignment.fdarecord.command.UpdateFdaRecordCommand;
import com.assignment.fdarecord.event.CreateFdaRecordEvent;
import com.assignment.fdarecord.event.DeleteFdaRecordEvent;
import com.assignment.fdarecord.event.UpdateFdaRecordEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FdaRecordTest {
    private static final String customerName = "markom8";

    private FixtureConfiguration<FdaRecordAggregate> fixture;
    private String applicationNumber;
    private List<String> productNumbers;

    @BeforeEach
    public void setUp() {
        fixture = new AggregateTestFixture<>(FdaRecordAggregate.class);
        applicationNumber = "12345";
        productNumbers = new ArrayList<>();
    }

    @Test
    public void should_dispatch_accountcreated_event_when_createarecord_command() {
        fixture.givenNoPriorActivity()
                .when(new CreateFdaRecordCommand(
                        applicationNumber,
                        "",
                        "",
                        productNumbers)
                )
                .expectEvents(new CreateFdaRecordEvent(
                        applicationNumber,
                        "",
                        "",
                        productNumbers)
                );
    }

    @Test
    public void should_dispatch_update_event_when_updaterecord_command() {
        fixture.given(new CreateFdaRecordCommand(
                applicationNumber,
                "",
                "",
                productNumbers))
                .when(new UpdateFdaRecordCommand(
                        applicationNumber,
                        "",
                        "",
                        productNumbers)
                )
                .expectEvents(new UpdateFdaRecordEvent(
                        applicationNumber,
                        "",
                        "",
                        productNumbers)
                );
    }

    @Test
    public void should_dispatch_delete_event_when_deleterecord_command() {
        fixture.given(new CreateFdaRecordCommand(
                applicationNumber,
                "",
                "",
                productNumbers))
                .when(new DeleteFdaRecordCommand(
                        applicationNumber,
                        "",
                        "",
                        productNumbers)
                )
                .expectEvents(new DeleteFdaRecordEvent(
                        applicationNumber)
                );
    }


}
