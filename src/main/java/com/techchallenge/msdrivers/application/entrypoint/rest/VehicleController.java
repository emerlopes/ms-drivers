package com.techchallenge.msdrivers.application.entrypoint.rest;

import com.techchallenge.msdrivers.application.entrypoint.rest.dto.VehicleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok().build();
    }
}
