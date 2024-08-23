package org.as2;

import org.as2.web.VehicleController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MainTest {

    //https://docs.spring.io/spring-framework/reference/testing/testcontext-framework/fixture-di.html.
    @Autowired
    private VehicleController controller;
    @Test
    @DisplayName("First example test case")
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
