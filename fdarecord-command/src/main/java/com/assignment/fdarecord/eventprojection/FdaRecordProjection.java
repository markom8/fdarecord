package com.assignment.fdarecord.eventprojection;


import com.assignment.fdarecord.domain.FdaRecordEntity;
import com.assignment.fdarecord.domain.FdaRecordRepository;
import com.assignment.fdarecord.domain.event.CreateFdaRecordEvent;
import com.assignment.fdarecord.domain.event.DeleteFdaRecordEvent;
import com.assignment.fdarecord.domain.event.UpdateFdaRecordEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class FdaRecordProjection {
    private final FdaRecordRepository repository;

    @EventHandler
    public void on(CreateFdaRecordEvent event) {
        log.debug("Fda record creation command {}", event.getApplicationNumber());
        FdaRecordEntity fdaRecordEntity = new FdaRecordEntity(
                event.getApplicationNumber(),
                event.getManufacturerName(),
                event.getSubstanceName(),
                event.getProductNumbers()
        );
        this.repository.save(fdaRecordEntity);
    }

    @EventHandler
    public void on(UpdateFdaRecordEvent event) {
        log.debug("Fda record update command {}", event.getApplicationNumber());
        FdaRecordEntity fdaRecordEntity = new FdaRecordEntity(
                event.getApplicationNumber(),
                event.getManufacturerName(),
                event.getSubstanceName(),
                event.getProductNumbers()
        );
        this.repository.save(fdaRecordEntity);
    }

    @EventHandler
    public void on(DeleteFdaRecordEvent event) {
        log.debug("Fda record delete command {}", event.getApplicationNumber());
        this.repository.deleteById(event.getApplicationNumber());
    }
}
