package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
