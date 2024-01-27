package com.techchallenge.msdrivers.domain.usecase.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.impl.ExecuteSaveDriverUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExecuteCreateDriverUseCaseImplTest {

    @Mock
    private IDriverDomainService personService;

    @InjectMocks
    private ExecuteSaveDriverUseCaseImpl executeCreatePersonUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() {
        DriverDomainEntityInput input = new DriverDomainEntityInput();

        DriverDomainEntityOutput output = new DriverDomainEntityOutput();
        output.setExternalDriverId(UUID.randomUUID());

        when(personService.createDriver(input)).thenReturn(output);

        CustomData<DriverDomainEntityOutput> result = executeCreatePersonUseCase.execute(input);

        assertNotNull(result);
        assertNotNull(result.getData());
        assertEquals(output, result.getData());
    }

}