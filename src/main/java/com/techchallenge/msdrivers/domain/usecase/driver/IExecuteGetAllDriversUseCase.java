package com.techchallenge.msdrivers.domain.usecase.driver;

import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.shared.IExecuteNoArgs;

import java.util.List;

public interface IExecuteGetAllDriversUseCase extends IExecuteNoArgs<CustomData<List<DriverDomainEntityOutput>>> {
}
