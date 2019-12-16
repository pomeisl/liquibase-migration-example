package com.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migration.domain.Evaluation;


public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
