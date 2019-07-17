package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.WaybillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaybillDetailRepository extends JpaRepository<WaybillDetail, Long> {
}
