package org.as2;

import org.as2.domain.Vehicle;
import org.as2.domain.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication annotation, which is actually
 * a combination of multiple annotations
 * <p>
 * 1.@EnableAutoConfiguration -> enables Spring Boot’s automatic configuration, so
 * your project will automatically be configured based on
 * dependencies , For example, if you have the spring-boot-starter-web dependency, Spring Boot assumes that you are
 * developing a web application and configures your application
 * accordingly
 * <p>
 * 2.@ComponentScan -> This enables the Spring Boot component scan to find all the
 * components of your application
 * <p>
 * 3.@Configuration -> This defines a class that can be used as a source of bean
 * definitions ( common reason for an application not working correctly is due to Spring Boot being unable to find critical classes)
 */
@SpringBootApplication
public class Main implements CommandLineRunner {
    // The Spring Boot starter package provides the Logback,can use for logging without any configuration
    // Logback uses Simple Logging Façade for Java (SLF4J) as its native interface
    private static final Logger logger = LoggerFactory.getLogger(
            Main.class
    );

    private final VehicleRepository repository;

    public Main(VehicleRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        // configure this in application.properties
        logger.trace("Application started");
    }

    // CommandLineRunner interface is used to run a piece of code when the application is started
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Vehicle("Ford", "Mustang", "Red",
                "ADF-1121", 2023, 59000,"Fast car"));
        repository.save(new Vehicle("Nissan", "Leaf", "White",
                "SSJ-3002", 2020, 29000,"Fast car"));
        repository.save(new Vehicle("Toyota", "Prius",
                "Silver", "KKO-0212", 2022, 39000,"reliable car"));
        // Fetch all cars and log to console
        for (Vehicle car : repository.findAll()) {
            logger.info("brand: {}, model: {}",
                    car.getBrand(), car.getModel());
        }

    }
}

