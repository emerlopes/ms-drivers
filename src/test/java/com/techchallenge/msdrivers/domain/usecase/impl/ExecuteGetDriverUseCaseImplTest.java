package com.techchallenge.msdrivers.domain.usecase.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.impl.ExecuteGetAllDriversUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExecuteGetDriverUseCaseImplTest {

    @Mock
    private IDriverDomainService personService;

    @InjectMocks
    private ExecuteGetAllDriversUseCaseImpl executeGetPersonUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() {
        var person = new DriverDomainEntityOutput();
        person.setExternalId(UUID.randomUUID());
        person.setName("Alice");
        person.setAge(30);
        person.setPhoneNumber("1234567890");

        List<DriverDomainEntityOutput> persons = List.of(person);
        when(personService.findAllDrivers()).thenReturn(persons);

        CustomData<List<DriverDomainEntityOutput>> result = executeGetPersonUseCase.execute();

        assertNotNull(result);
        assertNotNull(result.getData());
        assertFalse(result.getData().isEmpty());
        assertEquals(persons, result.getData());
    }

}