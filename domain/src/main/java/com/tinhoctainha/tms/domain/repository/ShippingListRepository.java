package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.ShippingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingListRepository extends JpaRepository<ShippingList, Long> {
}
