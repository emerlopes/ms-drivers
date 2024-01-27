package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteSaveDriverUseCase;
import org.springframework.stereotype.Service;

@Service
public class ExecuteSaveDriverUseCaseImpl implements IExecuteSaveDriverUseCase {

    private final IDriverDomainService personService;

    public ExecuteSaveDriverUseCaseImpl(IDriverDomainService personService) {
        this.personService = personService;
    }

    @Override
    public CustomData<DriverDomainEntityOutput> execute(DriverDomainEntityInput input) {

        final var driver = personService.createDriver(input);
        CustomData<DriverDomainEntityOutput> customData = new CustomData<>();
        customData.setData(driver);

        return customData;
    }
}
