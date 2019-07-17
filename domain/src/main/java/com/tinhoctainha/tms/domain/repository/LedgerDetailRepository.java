package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.LedgerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerDetailRepository extends JpaRepository<LedgerDetail, Long> {
}
