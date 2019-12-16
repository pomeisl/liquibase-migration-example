package com.migration;

import static java.nio.charset.StandardCharsets.UTF_8;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.skyscreamer.jsonassert.JSONCompareMode.STRICT;
import static org.skyscreamer.jsonassert.JSONCompareMode.STRICT_ORDER;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.util.StreamUtils.copyToString;

import static lombok.AccessLevel.PRIVATE;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;

import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EvaluationIT {

    @LocalServerPort
    int port;

    @Value("classpath:/response/evaluations.json")
    Resource evaluationsResource;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void evaluationsShouldBeRelatedToPeriod() throws IOException, JSONException {
        // GIVEN
        var expected = copyToString(evaluationsResource.getInputStream(), UTF_8);

        // WHEN
        var actual = restTemplate.getForObject("http://localhost:" + port + "/evaluation", String.class);

        // THEN
        assertEquals(expected, actual, STRICT);
    }

}
