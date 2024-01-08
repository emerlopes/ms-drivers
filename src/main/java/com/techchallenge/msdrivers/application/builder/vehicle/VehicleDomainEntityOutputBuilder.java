package com.techchallenge.msdrivers.application.builder.vehicle;

import com.techchallenge.msdrivers.domain.entity.driver.CustomDriverDomainEntityOutput;
import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityOutput;

import java.time.LocalDateTime;

public class VehicleDomainEntityOutputBuilder {

    private final VehicleDomainEntityOutput vehicleDomainEntityOutput;

    public VehicleDomainEntityOutputBuilder() {
        this.vehicleDomainEntityOutput = new VehicleDomainEntityOutput();
    }

    public VehicleDomainEntityOutputBuilder withVehicleId(Long vehicleId) {
        vehicleDomainEntityOutput.setVehicleId(vehicleId);
        return this;
    }

    public VehicleDomainEntityOutputBuilder withLicensePlateNumber(String licensePlateNumber) {
        vehicleDomainEntityOutput.setLicensePlateNumber(licensePlateNumber);
        return this;
    }

    public VehicleDomainEntityOutputBuilder withBrand(String brand) {
        vehicleDomainEntityOutput.setBrand(brand);
        return this;
    }

    public VehicleDomainEntityOutputBuilder withModel(String model) {
        vehicleDomainEntityOutput.setModel(model);
        return this;
    }

    public VehicleDomainEntityOutputBuilder withDriver(CustomDriverDomainEntityOutput driver) {
        vehicleDomainEntityOutput.setDriver(driver);
        return this;
    }

    public VehicleDomainEntityOutputBuilder withCreationDate(LocalDateTime creationDate) {
        vehicleDomainEntityOutput.setCreationAt(creationDate);
        return this;
    }

    public VehicleDomainEntityOutput build() {
        return vehicleDomainEntityOutput;
    }

}
