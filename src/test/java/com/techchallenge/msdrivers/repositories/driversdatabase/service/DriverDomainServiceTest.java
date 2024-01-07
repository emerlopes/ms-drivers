package com.techchallenge.msdrivers.repositories.driversdatabase.service;

import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IDriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DriverDomainServiceTest {

    @Mock
    private IDriverRepository personRepository;

    @InjectMocks
    private DriverDomainService personDomainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPerson() {
        DriverDomainEntityInput input = new DriverDomainEntityInput();

        var personEntity = new DriverEntity();

        when(personRepository.save(Mockito.any())).thenReturn(personEntity);

        DriverDomainEntityOutput result = personDomainService.createPerson(input);

        assertNotNull(result);
    }

    @Test
    void getPersons() {
        var personEntity = new DriverEntity();

        List<DriverEntity> personEntities = List.of(personEntity);
        when(personRepository.findAll()).thenReturn(personEntities);

        List<DriverDomainEntityOutput> result = personDomainService.getPersons();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

}