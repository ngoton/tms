package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.VehicleRemoval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRemovalRepository extends JpaRepository<VehicleRemoval, Long> {
}
