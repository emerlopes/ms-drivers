package com.techchallenge.msdrivers.domain.service;


import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;

import java.util.List;
import java.util.UUID;

public interface IDriverDomainService {
    DriverDomainEntityOutput createPerson(DriverDomainEntityInput driverDomainEntityInput);

    List<DriverDomainEntityOutput> findAllDrivers();

    DriverDomainEntityOutput findDriverByExternalId(UUID id);

    DriverEntity getDriverByExternalId(UUID id);

}
