package com.techchallenge.msdrivers.domain.service;


import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;

import java.util.List;

public interface IDriverDomainService {
    DriverDomainEntityOutput createPerson(DriverDomainEntityInput driverDomainEntityInput);

    List<DriverDomainEntityOutput> getPersons();


}
