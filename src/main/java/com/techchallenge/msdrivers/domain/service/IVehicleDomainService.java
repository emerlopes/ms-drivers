package com.techchallenge.msdrivers.domain.service;

import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;

public interface IVehicleDomainService {
    VehicleDomainEntityOutput createVehicle(VehicleDomainEntityInput vehicleDomainEntityInput);
}
