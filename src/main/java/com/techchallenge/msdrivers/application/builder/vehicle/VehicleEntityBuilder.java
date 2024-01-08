package com.techchallenge.msdrivers.application.builder.vehicle;

import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.VehicleEntity;

import java.time.LocalDateTime;

public class VehicleEntityBuilder {

    private final VehicleEntity vehicleEntity;

    public VehicleEntityBuilder() {
        this.vehicleEntity = new VehicleEntity();
    }

    public VehicleEntityBuilder withVehicleId(Long vehicleId) {
        vehicleEntity.setVehicleId(vehicleId);
        return this;
    }

    public VehicleEntityBuilder withLicensePlateNumber(String licensePlateNumber) {
        vehicleEntity.setLicensePlateNumber(licensePlateNumber);
        return this;
    }

    public VehicleEntityBuilder withBrand(String brand) {
        vehicleEntity.setBrand(brand);
        return this;
    }

    public VehicleEntityBuilder withModel(String model) {
        vehicleEntity.setModel(model);
        return this;
    }

    public VehicleEntityBuilder withDriver(DriverEntity driver) {
        vehicleEntity.setDriver(driver);
        return this;
    }

    public VehicleEntityBuilder withCreationDate(LocalDateTime creationDate) {
        vehicleEntity.setCreationDate(creationDate);
        return this;
    }

    public VehicleEntity build() {
        return vehicleEntity;
    }


}
