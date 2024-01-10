package com.techchallenge.msdrivers.domain.usecase.driver;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.shared.IExecuteArgs;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;

import java.util.UUID;

public interface IExecuteFindDriverByIdUseCase extends IExecuteArgs<CustomData<DriverEntity>, UUID> {
}
