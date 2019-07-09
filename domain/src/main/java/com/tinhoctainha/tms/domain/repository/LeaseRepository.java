package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseRepository extends JpaRepository<Lease, Long> {
}
