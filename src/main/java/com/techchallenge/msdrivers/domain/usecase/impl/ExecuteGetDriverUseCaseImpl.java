package com.techchallenge.msdrivers.domain.usecase.impl;


import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.IExecuteGetDriverUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecuteGetDriverUseCaseImpl implements IExecuteGetDriverUseCase {

    private final IDriverDomainService personService;

    public ExecuteGetDriverUseCaseImpl(IDriverDomainService personService) {
        this.personService = personService;
    }

    @Override
    public CustomData<List<DriverDomainEntityOutput>> execute() {
        final var persons = personService.getPersons();
        CustomData<List<DriverDomainEntityOutput>> customData = new CustomData<>();
        customData.setData(persons);
        return customData;
    }


}
