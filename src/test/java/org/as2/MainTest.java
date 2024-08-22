package org.as2;

import org.as2.web.VehicleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MainTest {

    @Autowired
    private VehicleController controller;
    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
