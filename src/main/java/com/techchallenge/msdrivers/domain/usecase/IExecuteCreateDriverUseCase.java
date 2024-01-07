package com.techchallenge.msdrivers.domain.usecase;


import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.shared.IExecuteArgs;

public interface IExecuteCreateDriverUseCase extends IExecuteArgs<CustomData<DriverDomainEntityOutput>, DriverDomainEntityInput> {
}
