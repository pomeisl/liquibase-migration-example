package com.migration.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.migration.domain.Period;
import com.migration.service.PeriodService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor

@RestController
@RequestMapping("periods")
public class PeriodResource {
    PeriodService periodService;

    @GetMapping
    public Collection<Period> periods() {
        return periodService.findAll();
    }
}
