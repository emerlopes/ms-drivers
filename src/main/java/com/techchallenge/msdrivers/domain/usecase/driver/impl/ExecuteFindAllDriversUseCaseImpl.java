package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteFindAllDriversUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecuteFindAllDriversUseCaseImpl implements IExecuteFindAllDriversUseCase {

    private final IDriverDomainService driverDomainService;

    public ExecuteFindAllDriversUseCaseImpl(IDriverDomainService personService) {
        this.driverDomainService = personService;
    }

    @Override
    public CustomData<List<DriverDomainEntityOutput>> execute() {
        final var drivers = driverDomainService.findAllDrivers();
        CustomData<List<DriverDomainEntityOutput>> customData = new CustomData<>();
        customData.setData(drivers);
        return customData;
    }


}
