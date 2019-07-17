package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
