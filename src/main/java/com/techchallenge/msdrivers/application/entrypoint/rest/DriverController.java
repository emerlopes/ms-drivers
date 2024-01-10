package com.techchallenge.msdrivers.application.entrypoint.rest;


import com.techchallenge.msdrivers.application.entrypoint.rest.dto.DriverDTO;
import com.techchallenge.msdrivers.application.mapper.driver.DriverMappers;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindDriverByIdUseCase;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteSaveDriverUseCase;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindAllDriversUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final IExecuteSaveDriverUseCase iExecuteSaveDriverUseCase;

    private final IExecuteFindAllDriversUseCase iExecuteFindAllDriversUseCase;

    private final IExecuteFindDriverByIdUseCase iExecuteFindDriverByIdUseCase;

    public DriverController(
            IExecuteSaveDriverUseCase iExecuteSaveDriverUseCase,
            IExecuteFindAllDriversUseCase iExecuteFindAllDriversUseCase, IExecuteFindDriverByIdUseCase iExecuteFindDriverByIdUseCase) {
        this.iExecuteSaveDriverUseCase = iExecuteSaveDriverUseCase;
        this.iExecuteFindAllDriversUseCase = iExecuteFindAllDriversUseCase;
        this.iExecuteFindDriverByIdUseCase = iExecuteFindDriverByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<?> findDrivers() {
        final var response = iExecuteFindAllDriversUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{externalDriverId}")
    public ResponseEntity<?> findDriverById(@PathVariable UUID externalDriverId) {
        final var response = iExecuteFindDriverByIdUseCase.execute(externalDriverId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> saveDriver(@Valid @RequestBody DriverDTO driverDTO) {

        final var personDomainEntity = DriverMappers.mapToDriverDomainEntityInput(driverDTO);
        final var response = iExecuteSaveDriverUseCase.execute(personDomainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
