package org.as2;

import org.as2.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

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
    private final OwnerRepository ownerRepository;
    private final AppUserRepository appUserRepository;

    public Main(VehicleRepository repository , OwnerRepository ownerRepository, AppUserRepository appUserRepository) {
        this.repository = repository;
        this.ownerRepository = ownerRepository;
        this.appUserRepository = appUserRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        // configure this in application.properties
        logger.trace("Application started");
    }

    // CommandLineRunner interface is used to run a piece of code when the application is started
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner("John" , "Johnson");
        Owner owner2 = new Owner("Mary" , "Robinson");
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));
        repository.save(new Vehicle("Ford", "Mustang", "Red",
                "ADF-1121", 2023, 59000,"Fast car",owner1));
        repository.save(new Vehicle("Nissan", "Leaf", "White",
                "SSJ-3002", 2020, 29000,"Fast car",owner1));
        repository.save(new Vehicle("Toyota", "Prius",
                "Silver", "KKO-0212", 2022, 39000,"reliable car",owner2));
        // Fetch all cars and log to console
        for (Vehicle car : repository.findAll()) {
            logger.info("brand: {}, model: {}",
                    car.getBrand(), car.getModel());
        }

        // Username: user, password: user
        appUserRepository.save(new AppUser("user",
                "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
        // Username: admin, password: admin
        appUserRepository.save(new AppUser("admin",
                        "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));

    }
}

