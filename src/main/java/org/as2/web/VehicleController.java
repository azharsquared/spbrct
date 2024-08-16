package org.as2.web;

import org.as2.domain.Vehicle;
import org.as2.domain.VehicleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// This is a REST controller for the Vehicle entity
@RestController
public class VehicleController {

    private final VehicleRepository repository;
    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/vehicles")
    public Iterable<Vehicle> getVehicles() {
        return repository.findAll();
    }

}
