package com.api.fleetmanagement.repositories;

import com.api.fleetmanagement.models.TrajectoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrajectoriesRepository extends JpaRepository<TrajectoriesModel, Integer> {

    @Query("SELECT t FROM TrajectoriesModel t LEFT JOIN FETCH t.taxi tr WHERE tr.id = :taxiId")
    List<TrajectoriesModel> findTrajectoriesByTaxiId(@Param("taxiId") Integer taxiId);
}
