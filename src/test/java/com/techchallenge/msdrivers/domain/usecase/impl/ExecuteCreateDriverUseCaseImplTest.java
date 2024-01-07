package com.techchallenge.msdrivers.domain.usecase.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.PersonDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IPersonDomainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExecuteCreatePersonUseCaseImplTest {

    @Mock
    private IPersonDomainService personService;

    @InjectMocks
    private ExecuteCreatePersonUseCaseImpl executeCreatePersonUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() {
        PersonDomainEntityInput input = new PersonDomainEntityInput();

        PersonDomainEntityOutput output = new PersonDomainEntityOutput();
        output.setExternalId(UUID.randomUUID());

        when(personService.createPerson(input)).thenReturn(output);

        CustomData<PersonDomainEntityOutput> result = executeCreatePersonUseCase.execute(input);

        assertNotNull(result);
        assertNotNull(result.getData());
        assertEquals(output, result.getData());
    }

}