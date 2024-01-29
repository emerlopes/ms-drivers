package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
class ExecuteFindAllDriversUseCaseImplTest {

    @InjectMocks
    private ExecuteFindAllDriversUseCaseImpl findAllDriversUseCase;

    @Mock
    private IDriverDomainService driverDomainService;

    @Test
    public void testExecuteWithDriversFound() {
        // Crie uma lista simulada de motoristas
        List<DriverDomainEntityOutput> driverList = new ArrayList<>();
        driverList.add(new DriverDomainEntityOutput(/* Preencha com dados simulados */));

        // Defina o comportamento do mock para driverDomainService
        when(driverDomainService.findAllDrivers()).thenReturn(driverList);

        // Execute o método execute() do caso de uso
        CustomData<List<DriverDomainEntityOutput>> result = findAllDriversUseCase.execute();

        // Verifique se o resultado contém os motoristas simulados
        assertEquals(driverList, result.getData());

        // Verifique se o método findAllDrivers foi chamado no serviço de domínio
        verify(driverDomainService, times(1)).findAllDrivers();
    }

    @Test
    public void testExecuteWithNoDriversFound() {
        // Defina o comportamento do mock para driverDomainService retornando uma lista vazia
        when(driverDomainService.findAllDrivers()).thenReturn(new ArrayList<>());

        // Execute o método execute() do caso de uso
        CustomData<List<DriverDomainEntityOutput>> result = findAllDriversUseCase.execute();

        // Verifique se o resultado contém uma lista vazia
        assertEquals(new ArrayList<>(), result.getData());

        // Verifique se o método findAllDrivers foi chamado no serviço de domínio
        verify(driverDomainService, times(1)).findAllDrivers();
    }

}