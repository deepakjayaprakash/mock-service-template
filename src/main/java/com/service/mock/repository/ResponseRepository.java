package com.service.mock.repository;

import com.service.mock.model.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ResponseRepository extends JpaRepository<ResponseEntity, Long>, JpaSpecificationExecutor<ResponseEntity> {
    @Query("from ResponseEntity where id = :responseId")
    ResponseEntity getByResponseId(@Param(value = "responseId") Long responseId);
}
