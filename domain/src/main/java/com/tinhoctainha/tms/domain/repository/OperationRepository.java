package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
