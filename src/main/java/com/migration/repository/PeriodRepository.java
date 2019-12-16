package com.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migration.domain.Period;

public interface PeriodRepository extends JpaRepository<Period, Long> {
}
