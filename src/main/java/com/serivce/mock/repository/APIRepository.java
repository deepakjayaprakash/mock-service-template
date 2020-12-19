package com.serivce.mock.repository;

import com.serivce.mock.model.APIEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface APIRepository extends JpaRepository<APIEntity, Long>, JpaSpecificationExecutor<APIEntity> {
    @Query("from APIEntity where id = :apiId")
    APIEntity getByAPIId(@Param(value = "apiId") Long apiId);
}
