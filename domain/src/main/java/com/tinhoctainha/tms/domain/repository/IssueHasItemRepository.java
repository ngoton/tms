package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.IssueHasItem;
import com.tinhoctainha.tms.domain.model.IssueHasItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueHasItemRepository extends JpaRepository<IssueHasItem, IssueHasItemId> {
}
