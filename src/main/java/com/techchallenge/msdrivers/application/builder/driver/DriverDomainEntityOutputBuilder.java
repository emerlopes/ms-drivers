package com.techchallenge.msdrivers.application.builder.driver;


import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;
import com.techchallenge.msdrivers.repositories.driversdatabase.entity.VehicleEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class DriverDomainEntityOutputBuilder {

    private final DriverDomainEntityOutput driverDomainEntityOutput;

    public DriverDomainEntityOutputBuilder() {
        driverDomainEntityOutput = new DriverDomainEntityOutput();
    }

    public DriverDomainEntityOutputBuilder withExternalId(UUID externalId) {
        driverDomainEntityOutput.setExternalDriverId(externalId);
        return this;
    }

    public DriverDomainEntityOutputBuilder withName(String name) {
        driverDomainEntityOutput.setName(name);
        return this;
    }

    public DriverDomainEntityOutputBuilder withAge(int age) {
        driverDomainEntityOutput.setAge(age);
        return this;
    }

    public DriverDomainEntityOutputBuilder withPhoneNumber(String phoneNumber) {
        driverDomainEntityOutput.setPhoneNumber(phoneNumber);
        return this;
    }

    public DriverDomainEntityOutputBuilder withVehicle(List<VehicleEntity> vehicle) {
        driverDomainEntityOutput.setVehicle(vehicle);
        return this;
    }

    public DriverDomainEntityOutputBuilder withCreatedAt(LocalDateTime createdAt) {
        driverDomainEntityOutput.setCreatedAt(createdAt);
        return this;
    }

    public DriverDomainEntityOutput build() {
        return driverDomainEntityOutput;
    }

}
