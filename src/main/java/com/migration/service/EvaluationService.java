package com.migration.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.migration.domain.Evaluation;
import com.migration.repository.EvaluationRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor

@Service
public class EvaluationService {
    EvaluationRepository evaluationRepository;

    public Collection<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }
}
