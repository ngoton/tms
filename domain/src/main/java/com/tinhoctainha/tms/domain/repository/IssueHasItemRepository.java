package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.IssueHasItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHasItemRepository extends JpaRepository<IssueHasItem, Long> {
}
