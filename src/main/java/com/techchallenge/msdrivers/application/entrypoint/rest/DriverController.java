package com.techchallenge.msdrivers.application.entrypoint.rest;


import com.techchallenge.msdrivers.application.entrypoint.rest.dto.DriverDTO;
import com.techchallenge.msdrivers.application.mapper.driver.DriverMappers;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteCreateDriverUseCase;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteGetAllDriversUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class DriverController {

    private final IExecuteCreateDriverUseCase executeCreatePersonUseCase;

    private final IExecuteGetAllDriversUseCase executeGetPersonUseCase;

    public DriverController(
            IExecuteCreateDriverUseCase executeCreatePersonUseCase,
            IExecuteGetAllDriversUseCase executeGetPersonUseCase) {
        this.executeCreatePersonUseCase = executeCreatePersonUseCase;
        this.executeGetPersonUseCase = executeGetPersonUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getPersons() {
        final var response = executeGetPersonUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@Valid @RequestBody DriverDTO driverDTO) {

        final var personDomainEntity = DriverMappers.mapToDriverDomainEntityInput(driverDTO);
        final var response = executeCreatePersonUseCase.execute(personDomainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
