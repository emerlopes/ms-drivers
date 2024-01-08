package com.techchallenge.msdrivers.domain.usecase.vehicle.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IVehicleDomainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExecuteCreateVehicleUseCaseImplTest {

    private ExecuteCreateVehicleUseCaseImpl useCase;
    private IVehicleDomainService vehicleDomainService;

    @BeforeEach
    public void setUp() {
        vehicleDomainService = mock(IVehicleDomainService.class);
        useCase = new ExecuteCreateVehicleUseCaseImpl(vehicleDomainService);
    }

    @Test
    public void testExecuteWithValidInput() {
        // Arrange
        VehicleDomainEntityInput input = new VehicleDomainEntityInput();
        VehicleDomainEntityOutput expectedOutput = new VehicleDomainEntityOutput();
        when(vehicleDomainService.createVehicle(input)).thenReturn(expectedOutput);

        // Act
        CustomData<VehicleDomainEntityOutput> customData = useCase.execute(input);

        // Assert
        assertNotNull(customData);
        assertEquals(expectedOutput, customData.getData());
    }

    @Test
    public void testExecuteWithNullInput() {
        // Arrange
        when(vehicleDomainService.createVehicle(null)).thenReturn(null);

        // Act
        CustomData<VehicleDomainEntityOutput> customData = useCase.execute(null);

        // Assert
        assertNotNull(customData);
        assertNull(customData.getData());
    }
}
