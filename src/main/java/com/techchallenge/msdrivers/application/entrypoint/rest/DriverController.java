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

/**
 * Controlador REST para lidar com operações relacionadas a motoristas.
 */
@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final IExecuteSaveDriverUseCase iExecuteSaveDriverUseCase;
    private final IExecuteFindAllDriversUseCase iExecuteFindAllDriversUseCase;
    private final IExecuteFindDriverByIdUseCase iExecuteFindDriverByIdUseCase;

    /**
     * Construtor da classe DriverController.
     *
     * @param iExecuteSaveDriverUseCase     Caso de uso para salvar motorista.
     * @param iExecuteFindAllDriversUseCase Caso de uso para buscar todos os motoristas.
     * @param iExecuteFindDriverByIdUseCase Caso de uso para buscar um motorista por ID externo.
     */
    public DriverController(
            IExecuteSaveDriverUseCase iExecuteSaveDriverUseCase,
            IExecuteFindAllDriversUseCase iExecuteFindAllDriversUseCase,
            IExecuteFindDriverByIdUseCase iExecuteFindDriverByIdUseCase) {
        this.iExecuteSaveDriverUseCase = iExecuteSaveDriverUseCase;
        this.iExecuteFindAllDriversUseCase = iExecuteFindAllDriversUseCase;
        this.iExecuteFindDriverByIdUseCase = iExecuteFindDriverByIdUseCase;
    }

    /**
     * Endpoint para buscar todos os motoristas.
     *
     * @return ResponseEntity com a lista de motoristas e status HTTP OK (200).
     */
    @GetMapping
    public ResponseEntity<?> findDrivers() {
        final var response = iExecuteFindAllDriversUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Endpoint para buscar um motorista pelo ID externo.
     *
     * @param externalDriverId ID externo do motorista a ser buscado.
     * @return ResponseEntity com o motorista encontrado e status HTTP OK (200).
     */
    @GetMapping("/{externalDriverId}")
    public ResponseEntity<?> findDriverById(@PathVariable UUID externalDriverId) {
        final var response = iExecuteFindDriverByIdUseCase.execute(externalDriverId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Endpoint para salvar um novo motorista.
     *
     * @param driverDTO DTO contendo os dados do motorista a ser salvo.
     * @return ResponseEntity com o motorista salvo e status HTTP CREATED (201).
     */
    @PostMapping
    public ResponseEntity<?> saveDriver(@Valid @RequestBody DriverDTO driverDTO) {

        final var personDomainEntity = DriverMappers.mapToDriverDomainEntityInput(driverDTO);
        final var response = iExecuteSaveDriverUseCase.execute(personDomainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
