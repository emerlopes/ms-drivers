package com.techchallenge.msdrivers.application.builder.vehicle;

import com.techchallenge.msdrivers.domain.entity.vehicle.VehicleDomainEntityInput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;

public class VehicleDomainEntityInputBuilder {

    private final VehicleDomainEntityInput vehicleDomainEntityInput;

    public VehicleDomainEntityInputBuilder() {
        this.vehicleDomainEntityInput = new VehicleDomainEntityInput();
    }

    public VehicleDomainEntityInputBuilder withLicensePlateNumber(String licensePlateNumber) {
        vehicleDomainEntityInput.setLicensePlateNumber(licensePlateNumber);
        return this;
    }

    public VehicleDomainEntityInputBuilder withBrand(String brand) {
        vehicleDomainEntityInput.setBrand(brand);
        return this;
    }

    public VehicleDomainEntityInputBuilder withModel(String model) {
        vehicleDomainEntityInput.setModel(model);
        return this;
    }

    public VehicleDomainEntityInputBuilder withDriver(DriverEntity driver) {
        vehicleDomainEntityInput.setDriver(driver);
        return this;
    }

    public VehicleDomainEntityInput build() {
        return vehicleDomainEntityInput;
    }


}
