package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findContactByCustomerId(Long id);
}
