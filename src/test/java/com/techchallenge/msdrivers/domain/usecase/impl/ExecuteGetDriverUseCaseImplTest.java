package com.techchallenge.msdrivers.domain.usecase.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IPersonDomainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExecuteGetPersonUseCaseImplTest {

    @Mock
    private IPersonDomainService personService;

    @InjectMocks
    private ExecuteGetPersonUseCaseImpl executeGetPersonUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute() {
        var person = new PersonDomainEntityOutput();
        person.setExternalId(UUID.randomUUID());
        person.setName("Alice");
        person.setAge(30);
        person.setPhoneNumber("1234567890");

        List<PersonDomainEntityOutput> persons = List.of(person);
        when(personService.getPersons()).thenReturn(persons);

        CustomData<List<PersonDomainEntityOutput>> result = executeGetPersonUseCase.execute();

        assertNotNull(result);
        assertNotNull(result.getData());
        assertFalse(result.getData().isEmpty());
        assertEquals(persons, result.getData());
    }

}