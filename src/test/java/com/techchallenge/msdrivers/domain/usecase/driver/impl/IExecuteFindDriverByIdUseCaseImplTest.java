package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class IExecuteFindDriverByIdUseCaseImplTest {


    @InjectMocks
    private IExecuteFindDriverByIdUseCaseImpl findDriverByIdUseCase;

    @Mock
    private IDriverDomainService driverDomainService;

    @Test
    public void testExecuteWithDriverFound() {
        UUID externalDriverId = UUID.randomUUID();
        // Crie um objeto DriverEntity simulado
        DriverEntity driverEntity = new DriverEntity();
        driverEntity.setExternalId(externalDriverId);
        driverEntity.setName("John Doe");
        // Defina o comportamento do mock para driverDomainService
        when(driverDomainService.getDriverByExternalId(externalDriverId)).thenReturn(driverEntity);

        // Execute o método execute() do caso de uso
        CustomData<DriverEntity> result = findDriverByIdUseCase.execute(externalDriverId);

        // Verifique se o resultado contém os dados simulados do motorista encontrado
        assertEquals(driverEntity, result.getData());

        // Verifique se o método getDriverByExternalId foi chamado no serviço de domínio com o ID correto
        verify(driverDomainService, times(1)).getDriverByExternalId(externalDriverId);
    }

    @Test
    public void testExecuteWithNoDriverFound() {
        UUID externalDriverId = UUID.randomUUID();
        // Defina o comportamento do mock para driverDomainService retornando null
        when(driverDomainService.getDriverByExternalId(externalDriverId)).thenReturn(null);

        // Execute o método execute() do caso de uso
        CustomData<DriverEntity> result = findDriverByIdUseCase.execute(externalDriverId);

        // Verifique se o resultado contém um campo de dados nulo (nenhum motorista encontrado)
        assertEquals(null, result.getData());

        // Verifique se o método getDriverByExternalId foi chamado no serviço de domínio com o ID correto
        verify(driverDomainService, times(1)).getDriverByExternalId(externalDriverId);
    }

}