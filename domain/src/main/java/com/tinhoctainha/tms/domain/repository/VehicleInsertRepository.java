package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.VehicleInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleInsertRepository extends JpaRepository<VehicleInsert, Long> {
}
