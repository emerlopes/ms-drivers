package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteCreateDriverUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteCreateDriverUseCaseImpl implements IExecuteCreateDriverUseCase {

    private final IDriverDomainService personService;

    public ExecuteCreateDriverUseCaseImpl(IDriverDomainService personService) {
        this.personService = personService;
    }

    @Override
    public CustomData<DriverDomainEntityOutput> execute(DriverDomainEntityInput driverDomainEntityInput) {

        final var person = personService.createPerson(driverDomainEntityInput);
        CustomData<DriverDomainEntityOutput> customData = new CustomData<>();
        customData.setData(person);
        return customData;
    }
}
