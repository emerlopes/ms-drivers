package com.techchallenge.msdrivers.repositories.driversdatabase.service;


import com.techchallenge.msdrivers.application.mapper.driver.DriverMappers;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IDriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DriverDomainService implements IDriverDomainService {

    private final IDriverRepository driverRepository;

    public DriverDomainService(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverDomainEntityOutput createDriver(DriverDomainEntityInput driverDomainEntityInput) {
        final var entity = DriverMappers.mapToDriverEntity(driverDomainEntityInput);
        final var personEntity = driverRepository.save(entity);

        return DriverMappers.mapToDriverDomainEntityOutput(personEntity);
    }

    @Override
    public List<DriverDomainEntityOutput> findAllDrivers() {
        final var entities = driverRepository.findAll();
        return DriverMappers.mapToDriverDomainEntitiesOutput(entities);
    }

    @Override
    public DriverDomainEntityOutput findDriverByExternalId(UUID driverExternalId) {
        final var driver = driverRepository.findByExternalId(driverExternalId);
        return DriverMappers.mapToDriverDomainEntityOutput(driver);
    }

    @Override
    public DriverEntity getDriverByExternalId(UUID id) {
        return driverRepository.findByExternalId(id);
    }
}
