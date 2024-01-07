package com.techchallenge.msdrivers.application.entrypoint.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody Object vehicleDTO) {
        return ResponseEntity.ok().build();
    }
}
