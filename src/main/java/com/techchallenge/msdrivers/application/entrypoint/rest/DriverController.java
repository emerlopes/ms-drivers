package com.techchallenge.msdrivers.application.entrypoint.rest;

import com.techchallenge.msdrivers.application.entrypoint.rest.dto.DriverDTO;
import com.techchallenge.msdrivers.application.mapper.driver.DriverMappers;
import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindDriverByIdUseCase;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteSaveDriverUseCase;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    private final IExecuteFindDriverByIdUseCase iExecuteFindDriverByIdUseCase;

    /**
     * Construtor da classe DriverController.
     *
     * @param iExecuteSaveDriverUseCase     Caso de uso para salvar motorista.
     * @param iExecuteFindDriverByIdUseCase Caso de uso para buscar um motorista por ID externo.
     */
    public DriverController(
            IExecuteSaveDriverUseCase iExecuteSaveDriverUseCase,
            IExecuteFindDriverByIdUseCase iExecuteFindDriverByIdUseCase) {
        this.iExecuteSaveDriverUseCase = iExecuteSaveDriverUseCase;
        this.iExecuteFindDriverByIdUseCase = iExecuteFindDriverByIdUseCase;
    }

    /**
     * Endpoint para buscar um motorista pelo ID externo.
     *
     * @param externalDriverId ID externo do motorista a ser buscado.
     * @return ResponseEntity com o motorista encontrado e status HTTP OK (200).
     */
    @Tag(name = "Driver", description = "API de Motoristas")
    @Operation(
            summary = "Buscar um motorista por ID externo",
            description = "Recupera os dados de um motorista específico usando seu ID externo."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida, motorista encontrado e retornado.")
    })
    @GetMapping(value = "/{externalDriverId}", produces = "application/json")
    public ResponseEntity<CustomData<DriverEntity>> findDriverById(@PathVariable UUID externalDriverId) {
        final var response = iExecuteFindDriverByIdUseCase.execute(externalDriverId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    /**
     * Endpoint para salvar um novo motorista.
     *
     * @param driverDTO DTO contendo os dados do motorista a ser salvo.
     * @return ResponseEntity com o motorista salvo e status HTTP CREATED (201).
     */
    @Tag(name = "Driver", description = "API de Motoristas")
    @Operation(
            summary = "Salvar um novo motorista",
            description = "Salva uma nova entidade de motorista com os dados fornecidos no DriverDTO. Um CPF válido deve ser informado: para testes usar o 30030030030"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação bem-sucedida, novo motorista criado e retornado.")
    })
    @PostMapping
    public ResponseEntity<CustomData<DriverDomainEntityOutput>> salvarMotorista(@Valid @RequestBody DriverDTO driverDTO) {

        final var entidadeDominioPessoa = DriverMappers.mapToDriverDomainEntityInput(driverDTO);
        final var resposta = iExecuteSaveDriverUseCase.execute(entidadeDominioPessoa);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

}
