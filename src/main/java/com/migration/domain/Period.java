package com.migration.domain;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data

@JsonInclude(NON_EMPTY)

@Entity
@Table(name = "periods")

@SequenceGenerator(name = "period_seq_gen", sequenceName = "period_seq", allocationSize = 1)
public class Period implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "period_seq_gen")
    Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "period")
    @JsonIgnore
    List<Evaluation> evaluations;

}
