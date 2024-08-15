package org.as2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @SpringBootApplication annotation, which is actually
 * a combination of multiple annotations
 *
 * 1.@EnableAutoConfiguration -> enables Spring Boot’s automatic configuration, so
 * your project will automatically be configured based on
 * dependencies , For example, if you have the spring-boot-starter-web dependency, Spring Boot assumes that you are
 * developing a web application and configures your application
 * accordingly
 *
 * 2.@ComponentScan -> This enables the Spring Boot component scan to find all the
 * components of your application
 *
 * 3.@Configuration -> This defines a class that can be used as a source of bean
 * definitions ( common reason for an application not working correctly is due to Spring Boot being unable to find critical classes)
 *
 *
 * */
@SpringBootApplication
public class Main {
    // The Spring Boot starter package provides the Logback,can use for logging without any configuration
    // Logback uses Simple Logging Façade for Java (SLF4J) as its native interface
    private static final Logger logger = LoggerFactory.getLogger(
            Main.class
    );
    public static void main(String[] args) {
        logger.info("Application started");
    }
}

