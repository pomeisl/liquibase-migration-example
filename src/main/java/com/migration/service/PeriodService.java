package com.migration.service;


import java.util.Collection;

import org.springframework.stereotype.Service;

import com.migration.domain.Period;
import com.migration.repository.PeriodRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor

@Service
public class PeriodService {
    PeriodRepository periodRepository;

    public Collection<Period> findAll() {
        return periodRepository.findAll();
    }
}
