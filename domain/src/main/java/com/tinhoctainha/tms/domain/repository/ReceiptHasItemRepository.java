package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.ReceiptHasItem;
import com.tinhoctainha.tms.domain.model.ReceiptHasItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptHasItemRepository extends JpaRepository<ReceiptHasItem, ReceiptHasItemId> {
}
