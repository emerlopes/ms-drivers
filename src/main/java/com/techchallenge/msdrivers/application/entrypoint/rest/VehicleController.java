package com.techchallenge.msdrivers.application.entrypoint.rest;

import com.techchallenge.msdrivers.application.entrypoint.rest.dto.VehicleDTO;
import com.techchallenge.msdrivers.application.mapper.vehicle.VehicleMappers;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindDriverByIdUseCase;
import com.techchallenge.msdrivers.domain.usecase.vehicle.IExecuteCreateVehicleUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final IExecuteCreateVehicleUseCase executeCreateVehicleUseCase;

    private final IExecuteFindDriverByIdUseCase executeGetDriverUseCase;

    public VehicleController(
            IExecuteCreateVehicleUseCase executeCreateVehicleUseCase,
            IExecuteFindDriverByIdUseCase executeGetDriverUseCase) {
        this.executeCreateVehicleUseCase = executeCreateVehicleUseCase;

        this.executeGetDriverUseCase = executeGetDriverUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        final var vehicleDomainEntityInput = VehicleMappers.mapToVechileDomainEntityInput(vehicleDTO);
        final var driverExternalId = vehicleDTO.getDriverExternalId();
        final var driver = executeGetDriverUseCase.execute(driverExternalId);

        vehicleDomainEntityInput.setDriver(driver.getData());

        final var response = executeCreateVehicleUseCase.execute(vehicleDomainEntityInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
