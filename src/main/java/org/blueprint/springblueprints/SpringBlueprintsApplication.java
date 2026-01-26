package org.blueprint.springblueprints;

import lombok.NoArgsConstructor;
import org.blueprint.springblueprints.config.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import static lombok.AccessLevel.PRIVATE;

@SpringBootApplication
@NoArgsConstructor(access = PRIVATE)
@EnableConfigurationProperties(ApplicationConfiguration.class)
public class SpringBlueprintsApplication {

    static void main(String[] args) {
        SpringApplication.run(SpringBlueprintsApplication.class, args);
    }

}
