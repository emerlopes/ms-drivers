package com.techchallenge.msdrivers.domain.usecase.driver;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.shared.IExecuteArgs;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;

import java.util.UUID;

public interface IExecuteGetDriverUseCase extends IExecuteArgs<CustomData<DriverEntity>, UUID> {
}
