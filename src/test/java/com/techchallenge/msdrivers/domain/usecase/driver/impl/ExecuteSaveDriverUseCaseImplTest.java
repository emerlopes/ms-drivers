package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ExecuteSaveDriverUseCaseImplTest {

    @InjectMocks
    private ExecuteSaveDriverUseCaseImpl saveDriverUseCase;

    @Mock
    private IDriverDomainService driverDomainService;

    @Test
    public void testExecute() {
        // Crie um objeto DriverDomainEntityInput simulado
        DriverDomainEntityInput input = new DriverDomainEntityInput(/* Preencha com dados simulados */);

        // Crie um objeto DriverDomainEntityOutput simulado
        DriverDomainEntityOutput output = new DriverDomainEntityOutput(/* Preencha com dados simulados */);

        // Defina o comportamento do mock para driverDomainService
        when(driverDomainService.createDriver(input)).thenReturn(output);

        // Execute o método execute() do caso de uso
        CustomData<DriverDomainEntityOutput> result = saveDriverUseCase.execute(input);

        // Verifique se o resultado contém os dados simulados do motorista criado
        assertEquals(output, result.getData());

        // Verifique se o método createDriver foi chamado no serviço de domínio com o input correto
        verify(driverDomainService, times(1)).createDriver(input);
    }

}