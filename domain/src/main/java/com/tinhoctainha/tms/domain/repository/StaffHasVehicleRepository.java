package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.StaffHasVehicle;
import com.tinhoctainha.tms.domain.model.StaffHasVehicleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffHasVehicleRepository extends JpaRepository<StaffHasVehicle, StaffHasVehicleId> {
}
