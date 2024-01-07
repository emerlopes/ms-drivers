package com.techchallenge.msdrivers.repositories.driversdatabase.service;

import com.techchallenge.msdrivers.application.mapper.vehicle.VehicleMappers;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;
import com.techchallenge.msdrivers.domain.service.IVehicleDomainService;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IDriverRepository;
import com.techchallenge.msdrivers.repositories.driversdatabase.repository.IVehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleDomainService implements IVehicleDomainService {

    private final IVehicleRepository vehicleRepository;

    public VehicleDomainService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDomainEntityOutput createVehicle(VehicleDomainEntityInput vehicleDomainEntityInput) {
        final var vehicleEntity = VehicleMappers.mapToVehileEntity(vehicleDomainEntityInput);

        final var entitySaved = vehicleRepository.save(vehicleEntity);

        return VehicleMappers.mapToVechileDomainEntityOutput(entitySaved);
    }
}
