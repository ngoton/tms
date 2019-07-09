package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
