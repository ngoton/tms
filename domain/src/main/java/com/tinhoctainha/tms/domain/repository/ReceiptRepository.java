package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
