package com.migration.domain;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static lombok.AccessLevel.PRIVATE;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
@Data

@JsonInclude(NON_EMPTY)

@Entity
@Table(name = "evaluations")

@SequenceGenerator(name = "evaluation_seq_gen", sequenceName = "evaluation_seq", allocationSize = 1)
public class Evaluation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_seq_gen")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "period_id", columnDefinition = "id", referencedColumnName = "id")
    Period period;
}
