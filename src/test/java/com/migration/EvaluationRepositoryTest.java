package com.migration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import static lombok.AccessLevel.PRIVATE;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.migration.domain.Evaluation;
import com.migration.repository.EvaluationRepository;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EvaluationRepositoryTest {

    EvaluationRepository evaluationRepository;

    @Test
    public void injectedComponentsAreNotNull() {
        assertThat(evaluationRepository, Matchers.notNullValue());
    }

    @Test
    public void testFindAll() {
        List<Evaluation> resultList = evaluationRepository.findAll();

        assertThat(resultList, hasSize(5));
    }

}
