package com.doctor.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.doctor.entity.Consulting;

public interface ConsultingRepository extends JpaRepository<Consulting, Long> {
  
}

