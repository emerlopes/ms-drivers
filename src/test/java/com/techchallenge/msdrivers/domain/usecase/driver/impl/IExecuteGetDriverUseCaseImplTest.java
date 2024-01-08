package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IExecuteGetDriverUseCaseImplTest {

    private IExecuteGetDriverUseCaseImpl useCase;
    private IDriverDomainService driverDomainService;

    @BeforeEach
    public void setUp() {
        driverDomainService = mock(IDriverDomainService.class);
        useCase = new IExecuteGetDriverUseCaseImpl(driverDomainService);
    }

    @Test
    public void testExecuteWithValidExternalDriverId() {
        // Arrange
        UUID externalDriverId = UUID.randomUUID();
        DriverEntity expectedDriverEntity = new DriverEntity();
        when(driverDomainService.getDriverByExternalId(externalDriverId)).thenReturn(expectedDriverEntity);

        // Act
        CustomData<DriverEntity> customData = useCase.execute(externalDriverId);

        // Assert
        assertNotNull(customData);
        assertEquals(expectedDriverEntity, customData.getData());
    }

    @Test
    public void testExecuteWithInvalidExternalDriverId() {
        // Arrange
        UUID invalidExternalDriverId = UUID.randomUUID();
        when(driverDomainService.getDriverByExternalId(invalidExternalDriverId)).thenReturn(null);

        // Act
        CustomData<DriverEntity> customData = useCase.execute(invalidExternalDriverId);

        // Assert
        assertNotNull(customData);
        assertNull(customData.getData());
    }
}
