package com.techchallenge.msdrivers.repositories.driversdatabase.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.VehicleEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IDriverRepository;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IVehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class VehicleDomainServiceTest {

    private VehicleDomainService vehicleDomainService;
    private IVehicleRepository vehicleRepository;
    private IDriverRepository driverRepository;

    @BeforeEach
    public void setUp() {
        vehicleRepository = mock(IVehicleRepository.class);
        driverRepository = mock(IDriverRepository.class);
        vehicleDomainService = new VehicleDomainService(vehicleRepository, driverRepository);
    }

    @Test
    public void testCreateVehicle() {
        // Arrange
        VehicleDomainEntityInput input = new VehicleDomainEntityInput();
        final var driver = new DriverEntity();
        driver.setExternalId(UUID.randomUUID());
        input.setDriver(driver);
        VehicleEntity expectedVehicleEntity = new VehicleEntity();
        expectedVehicleEntity.setDriver(driver);
        when(vehicleRepository.save(any())).thenReturn(expectedVehicleEntity);

        // Act
        VehicleDomainEntityOutput output = vehicleDomainService.createVehicle(input);

        // Assert
        assertNotNull(output);
        verify(driverRepository, times(1)).save(expectedVehicleEntity.getDriver());
    }
}
