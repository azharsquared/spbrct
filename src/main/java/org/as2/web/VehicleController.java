package org.as2.web;

import org.as2.domain.Vehicle;
import org.as2.domain.VehicleRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// This is a REST controller for the Vehicle entity
@RestController
public class VehicleController {

    private final VehicleRepository repository;
    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }
    @GetMapping("user/vehicles")
    public Iterable<Vehicle> getVehicles() {
        return repository.findAll();
    }

    @DeleteMapping("user/vehicle/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        System.out.println("Deleting vehicle with id: " + id);
        repository.deleteById(id);
    }


}
