package com.techchallenge.msdrivers.domain.usecase.driver.impl;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IDriverDomainService;
import com.techchallenge.msdrivers.domain.usecase.driver.IExecuteGetDriverUseCase;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IExecuteGetDriverUseCaseImpl implements IExecuteGetDriverUseCase {

    private final IDriverDomainService driverDomainService;

    public IExecuteGetDriverUseCaseImpl(IDriverDomainService driverDomainService) {
        this.driverDomainService = driverDomainService;
    }

    @Override
    public CustomData<DriverEntity> execute(UUID externalDriverId) {
        final var driver = driverDomainService.getDriverByExternalId(externalDriverId);
        CustomData<DriverEntity> customData = new CustomData<>();
        customData.setData(driver);
        return customData;
    }
}
