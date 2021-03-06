package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.VehicleHasRomooc;
import com.tinhoctainha.tms.domain.model.VehicleHasRomoocId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleHasRomoocRepository extends JpaRepository<VehicleHasRomooc, VehicleHasRomoocId> {
}
