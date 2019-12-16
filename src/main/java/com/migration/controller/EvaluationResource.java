package com.migration.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.migration.domain.Evaluation;
import com.migration.service.EvaluationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor

@RestController
@RequestMapping("evaluation")
public class EvaluationResource {

    EvaluationService evaluationService;

    @GetMapping
    public Collection<Evaluation> evaluations() {
        return evaluationService.findAll();
    }
}
