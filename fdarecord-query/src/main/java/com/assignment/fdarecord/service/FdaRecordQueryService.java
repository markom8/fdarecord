package com.assignment.fdarecord.service;


import com.assignment.fdarecord.domain.FdaRecordEntity;
import com.assignment.fdarecord.domain.FdaRecordRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class FdaRecordQueryService {
    private final QueryGateway queryGateway;
    private final EventStore eventStore;
    private final FdaRecordRepository fdaRecordRepository;

    public Optional<FdaRecordEntity> findById(String applicationNumber) {
        return fdaRecordRepository.findById(applicationNumber);
    }

    public List<FdaRecordEntity> getAllStoredFdaRecordEntries() {
        return fdaRecordRepository.findAll();
    }

    public List<?> listEventsForRecord(String applicationNumber) {
        return this.eventStore
                .readEvents(applicationNumber)
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }

}
