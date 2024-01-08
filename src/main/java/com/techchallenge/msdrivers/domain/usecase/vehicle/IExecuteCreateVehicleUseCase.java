package com.techchallenge.msdrivers.domain.usecase.vehicle;


import com.techchallenge.msdrivers.application.shared.CustomData;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;
import com.techchallenge.msdrivers.domain.shared.IExecuteArgs;

public interface IExecuteCreateVehicleUseCase extends IExecuteArgs<CustomData<VehicleDomainEntityOutput>, VehicleDomainEntityInput> {
}
