package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
