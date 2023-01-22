package com.assignment.fdarecord.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FdaRecordRepository extends JpaRepository<FdaRecordEntity, String> {

}
