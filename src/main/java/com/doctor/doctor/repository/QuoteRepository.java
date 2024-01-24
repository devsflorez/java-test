package com.doctor.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.doctor.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
  
}
