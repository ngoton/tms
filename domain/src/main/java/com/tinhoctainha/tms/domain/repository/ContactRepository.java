package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
