package com.techchallenge.msdrivers.application.mapper.vehicle;

import com.techchallenge.msdrivers.application.builder.vehicle.VehicleDomainEntityInputBuilder;
import com.techchallenge.msdrivers.application.builder.vehicle.VehicleDomainEntityOutputBuilder;
import com.techchallenge.msdrivers.application.builder.vehicle.VehicleEntityBuilder;
import com.techchallenge.msdrivers.application.entrypoint.rest.dto.VehicleDTO;
import com.techchallenge.msdrivers.application.mapper.driver.DriverMappers;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.VehicleEntity;

import java.time.LocalDateTime;

public class VehicleMappers {
    public static VehicleDomainEntityInput mapToVechileDomainEntityInput(VehicleDTO vehicleDTO) {
        return new VehicleDomainEntityInputBuilder()
                .withLicensePlateNumber(vehicleDTO.getLicensePlateNumber())
                .withBrand(vehicleDTO.getBrand())
                .withModel(vehicleDTO.getModel())
                .build();
    }

    public static VehicleDomainEntityOutput mapToVechileDomainEntityOutput(VehicleEntity vehicleEntity) {
        final var driverDomainEntityOutput = DriverMappers.mapToCustomDriverDomainEntityOutput(vehicleEntity.getDriver());
        return new VehicleDomainEntityOutputBuilder()
                .withVehicleId(vehicleEntity.getVehicleId())
                .withLicensePlateNumber(vehicleEntity.getLicensePlateNumber())
                .withBrand(vehicleEntity.getBrand())
                .withModel(vehicleEntity.getModel())
                .withDriver(driverDomainEntityOutput)
                .withCreationDate(vehicleEntity.getCreationDate())
                .build();
    }

    public static VehicleEntity mapToVehileEntity(VehicleDomainEntityInput vehicleDomainEntityInput) {
        return new VehicleEntityBuilder()
                .withLicensePlateNumber(vehicleDomainEntityInput.getLicensePlateNumber())
                .withBrand(vehicleDomainEntityInput.getBrand())
                .withModel(vehicleDomainEntityInput.getModel())
                .withDriver(vehicleDomainEntityInput.getDriver())
                .withCreationDate(LocalDateTime.now())
                .build();
    }
}
