package com.techchallenge.msdrivers.application.entrypoint.rest;

import com.techchallenge.msdrivers.application.entrypoint.rest.dto.PersonDTO;
import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.domain.usecase.IExecuteArgsCreatePersonUseCase;
import com.techchallenge.msdrivers.domain.usecase.IExecuteArgsGetPersonUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PersonControllerTest {

    @Mock
    private IExecuteArgsCreatePersonUseCase executeCreatePersonUseCase;

    @Mock
    private IExecuteArgsGetPersonUseCase executeGetPersonUseCase;

    @InjectMocks
    private PersonController personController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPersons() {
        UUID externalId = UUID.randomUUID();
        String name = "Alice";
        int age = 30;
        String phoneNumber = "1234567890";

        PersonDomainEntityOutput personOutput = new PersonDomainEntityOutput();
        personOutput.setExternalId(externalId);
        personOutput.setName(name);
        personOutput.setAge(age);
        personOutput.setPhoneNumber(phoneNumber);

        CustomData<List<PersonDomainEntityOutput>> customData = new CustomData<>();

        List<PersonDomainEntityOutput> persons = List.of(personOutput);
        customData.setData(persons);
        when(executeGetPersonUseCase.execute()).thenReturn(customData);

        ResponseEntity<?> response = personController.getPersons();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customData, response.getBody());
    }

    @Test
    void testCreatePerson() {
        PersonDTO personDTO = new PersonDTO();

        UUID externalId = UUID.randomUUID();
        String name = "Bob";
        int age = 35;
        String phoneNumber = "0987654321";

        CustomData<PersonDomainEntityOutput> customData = new CustomData<>();

        PersonDomainEntityOutput expectedResponse = new PersonDomainEntityOutput();
        expectedResponse.setExternalId(externalId);
        expectedResponse.setName(name);
        expectedResponse.setAge(age);
        expectedResponse.setPhoneNumber(phoneNumber);

        customData.setData(expectedResponse);

        when(executeCreatePersonUseCase.execute(any())).thenReturn(customData);

        ResponseEntity<?> response = personController.createPerson(personDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customData, response.getBody());
    }
}