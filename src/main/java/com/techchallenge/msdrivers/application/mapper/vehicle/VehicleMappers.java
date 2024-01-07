package com.techchallenge.msdrivers.application.mapper.vehicle;

import com.techchallenge.msdrivers.application.builder.vehicle.VehicleDomainEntityInputBuilder;
import com.techchallenge.msdrivers.application.entrypoint.rest.dto.VehicleDTO;
import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;

public class VehicleMappers {
    public static VehicleDomainEntityInput mapToVechileDomainEntityInput(VehicleDTO vehicleDTO) {
        return new VehicleDomainEntityInputBuilder()
                .withLicensePlateNumber(vehicleDTO.getLicensePlateNumber())
                .withBrand(vehicleDTO.getBrand())
                .withModel(vehicleDTO.getModel())
                .build();

    }
}
