package com.techchallenge.msdrivers.application.entrypoint.rest;

import com.techchallenge.msdrivers.application.entrypoint.rest.dto.VehicleDTO;
import com.techchallenge.msdrivers.application.mapper.vehicle.VehicleMappers;
import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindDriverByIdUseCase;
import com.techchallenge.msdrivers.domain.usecase.vehicle.IExecuteCreateVehicleUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para lidar com operações relacionadas a veículos.
 */
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final IExecuteCreateVehicleUseCase executeCreateVehicleUseCase;
    private final IExecuteFindDriverByIdUseCase executeGetDriverUseCase;

    /**
     * Construtor da classe VehicleController.
     *
     * @param executeCreateVehicleUseCase Caso de uso para criar um novo veículo.
     * @param executeGetDriverUseCase     Caso de uso para buscar um motorista por ID externo.
     */
    public VehicleController(
            IExecuteCreateVehicleUseCase executeCreateVehicleUseCase,
            IExecuteFindDriverByIdUseCase executeGetDriverUseCase) {
        this.executeCreateVehicleUseCase = executeCreateVehicleUseCase;
        this.executeGetDriverUseCase = executeGetDriverUseCase;
    }

    /**
     * Endpoint para criar um novo veículo.
     *
     * @param vehicleDTO DTO contendo os dados do veículo a ser criado.
     * @return ResponseEntity com o veículo criado e status HTTP CREATED (201).
     */
    @Tag(name = "Vehicle", description = "API de Veículos")
    @Operation(
            summary = "Criar um novo veículo",
            description = "Cria um novo veículo com os dados fornecidos no VehicleDTO."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação bem-sucedida, novo veículo criado e retornado.")
    })
    @PostMapping
    public ResponseEntity<CustomData<VehicleDomainEntityOutput>> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        final var vehicleDomainEntityInput = VehicleMappers.mapToVechileDomainEntityInput(vehicleDTO);
        final var driverExternalId = vehicleDTO.getDriverExternalId();
        final var driver = executeGetDriverUseCase.execute(driverExternalId);

        vehicleDomainEntityInput.setDriver(driver.getData());

        final var response = executeCreateVehicleUseCase.execute(vehicleDomainEntityInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
