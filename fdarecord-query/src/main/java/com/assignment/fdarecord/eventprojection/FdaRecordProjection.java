package com.assignment.fdarecord.eventprojection;

import com.assignment.fdarecord.domain.FdaRecordEntity;
import com.assignment.fdarecord.domain.FdaRecordRepository;
import com.assignment.fdarecord.query.FindFdaRecordQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class FdaRecordProjection {
    private final FdaRecordRepository repository;
    private final QueryUpdateEmitter updateEmitter;

    @QueryHandler
    public FdaRecordEntity handle(FindFdaRecordQuery query) {
        log.debug("Handling FindBankAccountQuery query: {}", query);
        return this.repository.findById(query.getApplicationNumber()).orElse(null);
    }

}
