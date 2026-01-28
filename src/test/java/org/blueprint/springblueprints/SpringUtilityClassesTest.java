package org.blueprint.springblueprints;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class SpringUtilityClassesTest {

    private final Resource request = new ClassPathResource("http-request-payload.json");

    @Test
    @SneakyThrows
    void copyToString() {
        try (val is = request.getInputStream()) {
            assertThat(StreamUtils.copyToString(is, StandardCharsets.UTF_8))
                    .isNotBlank()
                    .isEqualToIgnoringWhitespace("""
                            {
                              "superhero": "Homelander",
                              "action": "Shot with laser beams from eyes"
                            }
                            """);
        }
    }

    @Test
    @SneakyThrows
    void copyToByteArray() {
        try (val is = request.getInputStream()) {
            assertThat(StreamUtils.copyToByteArray(is)).asString()
                    .isEqualToIgnoringWhitespace("""
                            {
                              "superhero": "Homelander",
                              "action": "Shot with laser beams from eyes"
                            }
                            """);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    @ValueSource(ints = {1, 2})
    void testInstanceOfWithPatternMatching(Object value) {
        if (value instanceof String str) {
            assertThat(str).isInstanceOf(String.class).isNotBlank();
        } else if (value instanceof Integer integer) {
            assertThat(integer).isInstanceOf(Integer.class).isGreaterThan(0);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + value.getClass());
        }
    }

}
