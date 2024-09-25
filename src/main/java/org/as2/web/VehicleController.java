package org.as2.web;

import org.as2.domain.Vehicle;
import org.as2.domain.VehicleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @PostMapping("user/vehicle")
    public void addVehicle(@RequestBody Vehicle vehicle) {
        System.out.println("Adding vehicle: " + vehicle);
        repository.save(vehicle);
    }

    @PutMapping("user/vehicle/{id}")
    public void updateVehicle(@RequestBody Vehicle vehicle,@PathVariable("id") String id) {
        System.out.println("Updating vehicle: " + vehicle);
        Optional<Vehicle> find = repository.findById(Long.getLong(id));
        if(find.isPresent()) {
            Vehicle v = find.get();
            v.setBrand(vehicle.getBrand());
            v.setColor(vehicle.getColor());
            v.setDescription(vehicle.getDescription());
            v.setModel(vehicle.getModel());
            v.setModelYear(vehicle.getModelYear());
            v.setPrice(vehicle.getPrice());
            v.setRegistrationNumber(vehicle.getRegistrationNumber());
            repository.save(v);
        }
      //  repository.save(vehicle);
    }


}
