package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
}
