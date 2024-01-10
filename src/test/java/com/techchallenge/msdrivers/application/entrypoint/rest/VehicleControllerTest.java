package com.techchallenge.msdrivers.application.entrypoint.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.techchallenge.msdrivers.application.entrypoint.rest.dto.VehicleDTO;
import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindDriverByIdUseCase;
import com.techchallenge.msdrivers.domain.usecase.vehicle.IExecuteCreateVehicleUseCase;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class VehicleControllerTest {

    @InjectMocks
    private VehicleController vehicleController;
    @Mock
    private IExecuteCreateVehicleUseCase createVehicleUseCase;
    @Mock
    private IExecuteFindDriverByIdUseCase getDriverUseCase;

    @BeforeEach
    public void setUp() {
        createVehicleUseCase = mock(IExecuteCreateVehicleUseCase.class);
        getDriverUseCase = mock(IExecuteFindDriverByIdUseCase.class);
        vehicleController = new VehicleController(createVehicleUseCase, getDriverUseCase);
    }

    @Test
    public void testCreateVehicleWithValidInput() {
        // Arrange
        VehicleDTO vehicleDTO = new VehicleDTO();
        final var externalId = UUID.randomUUID();
        vehicleDTO.setDriverExternalId(externalId);

        VehicleDomainEntityInput vehicleInput = new VehicleDomainEntityInput();

        when(getDriverUseCase.execute(externalId)).thenReturn(new CustomData<>());

        when(createVehicleUseCase.execute(vehicleInput)).thenReturn(new CustomData<>());

        // Act
        ResponseEntity<?> response = vehicleController.createVehicle(vehicleDTO);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(new CustomData<>(), response.getBody());
    }

}
