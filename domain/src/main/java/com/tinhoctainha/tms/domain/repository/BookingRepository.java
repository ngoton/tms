package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
