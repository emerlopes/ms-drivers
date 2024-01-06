package com.techchallenge.msdrivers.repositories.driversdatabase.service;

import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.PersonEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonDomainServiceTest {

    @Mock
    private IPersonRepository personRepository;

    @InjectMocks
    private PersonDomainService personDomainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPerson() {
        PersonDomainEntityInput input = new PersonDomainEntityInput();

        var personEntity = new PersonEntity();

        when(personRepository.save(Mockito.any())).thenReturn(personEntity);

        PersonDomainEntityOutput result = personDomainService.createPerson(input);

        assertNotNull(result);
    }

    @Test
    void getPersons() {
        var personEntity = new PersonEntity();

        List<PersonEntity> personEntities = List.of(personEntity);
        when(personRepository.findAll()).thenReturn(personEntities);

        List<PersonDomainEntityOutput> result = personDomainService.getPersons();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

}