package org.blueprint.springblueprints.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@ConfigurationProperties(prefix = "blueprint-config")
@Slf4j
public record ApplicationConfiguration(
        Set<String> features,
        String primaryCdnProvider
) {

    @PostConstruct
    public void init() {
      log.info("Initializing blueprint config {}", this);
    }

}
