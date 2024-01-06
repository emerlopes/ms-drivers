package com.techchallenge.msdrivers.repositories.driversdatabase.service;


import com.techchallenge.msdrivers.application.mapper.Mappers;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.PersonDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IPersonDomainService;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDomainService implements IPersonDomainService {

    private final IPersonRepository personRepository;

    public PersonDomainService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonDomainEntityOutput createPerson(PersonDomainEntityInput personDomainEntityInput) {
        final var entity = Mappers.mapToPersonEntity(personDomainEntityInput);
        final var personEntity = personRepository.save(entity);

        return Mappers.mapToPersonDomainEntityOutput(personEntity);
    }

    @Override
    public List<PersonDomainEntityOutput> getPersons() {
        final var entities = personRepository.findAll();
        return Mappers.mapToPersonDomainEntitiesOutput(entities);
    }
}
