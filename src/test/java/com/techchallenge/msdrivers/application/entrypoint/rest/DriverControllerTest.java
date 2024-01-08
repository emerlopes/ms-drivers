package com.techchallenge.msdrivers.application.entrypoint.rest;

import com.techchallenge.msdrivers.application.entrypoint.rest.dto.DriverDTO;
import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteCreateDriverUseCase;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteGetAllDriversUseCase;
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

class DriverControllerTest {

    @Mock
    private IExecuteCreateDriverUseCase executeCreatePersonUseCase;

    @Mock
    private IExecuteGetAllDriversUseCase executeGetPersonUseCase;

    @InjectMocks
    private DriverController driverController;

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

        DriverDomainEntityOutput personOutput = new DriverDomainEntityOutput();
        personOutput.setExternalId(externalId);
        personOutput.setName(name);
        personOutput.setAge(age);
        personOutput.setPhoneNumber(phoneNumber);

        CustomData<List<DriverDomainEntityOutput>> customData = new CustomData<>();

        List<DriverDomainEntityOutput> persons = List.of(personOutput);
        customData.setData(persons);
        when(executeGetPersonUseCase.execute()).thenReturn(customData);

        ResponseEntity<?> response = driverController.findDrivers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customData, response.getBody());
    }

    @Test
    void testCreatePerson() {
        DriverDTO driverDTO = new DriverDTO();

        UUID externalId = UUID.randomUUID();
        String name = "Bob";
        int age = 35;
        String phoneNumber = "0987654321";

        CustomData<DriverDomainEntityOutput> customData = new CustomData<>();

        DriverDomainEntityOutput expectedResponse = new DriverDomainEntityOutput();
        expectedResponse.setExternalId(externalId);
        expectedResponse.setName(name);
        expectedResponse.setAge(age);
        expectedResponse.setPhoneNumber(phoneNumber);

        customData.setData(expectedResponse);

        when(executeCreatePersonUseCase.execute(any())).thenReturn(customData);

        ResponseEntity<?> response = driverController.createPerson(driverDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customData, response.getBody());
    }
}