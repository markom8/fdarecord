package com.assignment.fdarecord.controller;


import com.assignment.fdarecord.controller.dto.FdaRecordDTO;
import com.assignment.fdarecord.domain.FdaRecordEntity;
import com.assignment.fdarecord.service.FdaRecordCommandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/fda")
@AllArgsConstructor
public class FdaRecordsCommandController {
    private final FdaRecordCommandService commandService;

    @PostMapping(value = "create")
    @ResponseStatus(value = CREATED)
    public CompletableFuture<FdaRecordEntity> createFdaRecord(@Valid @RequestBody FdaRecordDTO creationDTO) {
        return this.commandService.createRecord(creationDTO);
    }

    @PutMapping(value = "update/{applicationNumber}")
    @ResponseStatus(value = ACCEPTED)
    public CompletableFuture<String> updateFdaRecord(@PathVariable(value = "applicationNumber") String applicationNumber,
                                                          @RequestBody FdaRecordDTO creationDTO) {
        return this.commandService.updateRecord(applicationNumber, creationDTO);
    }

    @DeleteMapping(value = "delete/{applicationNumber}")
    @ResponseStatus(value = ACCEPTED)
    public CompletableFuture<String> deleteFdaRecord(@PathVariable(value = "applicationNumber") String applicationNumber) {
        return this.commandService.deleteRecord(applicationNumber);
    }
}
