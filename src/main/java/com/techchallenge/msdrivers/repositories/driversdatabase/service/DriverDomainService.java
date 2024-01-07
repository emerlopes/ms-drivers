package com.techchallenge.msdrivers.repositories.driversdatabase.service;


import com.techchallenge.msdrivers.application.mapper.driver.DriverMappers;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IDriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverDomainService implements IDriverDomainService {

    private final IDriverRepository personRepository;

    public DriverDomainService(IDriverRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public DriverDomainEntityOutput createPerson(DriverDomainEntityInput driverDomainEntityInput) {
        final var entity = DriverMappers.mapToDriverEntity(driverDomainEntityInput);
        final var personEntity = personRepository.save(entity);

        return DriverMappers.mapToDriverDomainEntityOutput(personEntity);
    }

    @Override
    public List<DriverDomainEntityOutput> getPersons() {
        final var entities = personRepository.findAll();
        return DriverMappers.mapToDriverDomainEntitiesOutput(entities);
    }
}
