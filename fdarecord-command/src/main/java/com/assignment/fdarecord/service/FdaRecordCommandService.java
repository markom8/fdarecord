package com.assignment.fdarecord.service;


import com.assignment.fdarecord.command.CreateFdaRecordCommand;
import com.assignment.fdarecord.command.DeleteFdaRecordCommand;
import com.assignment.fdarecord.command.UpdateFdaRecordCommand;
import com.assignment.fdarecord.controller.dto.FdaRecordDTO;
import com.assignment.fdarecord.domain.FdaRecordEntity;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
@AllArgsConstructor
public class FdaRecordCommandService {
    private final CommandGateway commandGateway;

    public CompletableFuture<FdaRecordEntity> createRecord(FdaRecordDTO creationDTO) {

        return this.commandGateway.send(new CreateFdaRecordCommand(
                creationDTO.getApplicationNumber(),
                creationDTO.getManufacturerName(),
                creationDTO.getSubstanceName(),
                creationDTO.getProductNumbers()
        ));
    }

    public CompletableFuture<String> updateRecord(String applicationNumber,
                                                          FdaRecordDTO dto) {

        return this.commandGateway.send(new UpdateFdaRecordCommand(
                applicationNumber,
                dto.getManufacturerName(),
                dto.getSubstanceName(),
                dto.getProductNumbers()
        ));
    }

    public CompletableFuture<String> deleteRecord(String applicationNumber) {
        return this.commandGateway.send(new DeleteFdaRecordCommand(applicationNumber, null, null, null));
    }
}
