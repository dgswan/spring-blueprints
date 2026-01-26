package org.blueprint.springblueprints;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;
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

}
