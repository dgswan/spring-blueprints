package org.blueprint.springblueprints;

import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static lombok.AccessLevel.PRIVATE;

@SpringBootApplication
@NoArgsConstructor(access = PRIVATE)
public class SpringBlueprintsApplication {

    static void main(String[] args) {
        SpringApplication.run(SpringBlueprintsApplication.class, args);
    }

}
