package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Route;
import com.tinhoctainha.tms.domain.model.RouteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, RouteId> {
}
