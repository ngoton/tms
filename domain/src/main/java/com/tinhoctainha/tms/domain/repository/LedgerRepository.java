package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Long> {
}
