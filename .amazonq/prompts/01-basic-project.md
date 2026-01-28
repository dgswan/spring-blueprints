# Spring Boot Project Initialization

Create a Spring Boot 4.0.1 project with Java 25 using Maven.

## pom.xml
- Parent: spring-boot-starter-parent 4.0.1
- GroupId: org.blueprint
- ArtifactId: spring-blueprints
- Java version: 25

## Dependencies
- spring-boot-starter-web
- lombok (optional)
- spring-boot-starter-test (test scope)

## Maven Compiler Plugin
Configure annotation processor paths for Lombok.

## Main Application
Package: org.blueprint.springblueprints
Class: SpringBlueprintsApplication with @SpringBootApplication

## Resources
application.yaml with spring.application.name: spring-blueprints
