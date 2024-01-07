package com.techchallenge.msdrivers.application.builder;


import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityOutput;

import java.util.UUID;

public class DriverDomainEntityOutputBuilder {

    private final DriverDomainEntityOutput driverDomainEntityOutput;

    public DriverDomainEntityOutputBuilder() {
        driverDomainEntityOutput = new DriverDomainEntityOutput();
    }

    public DriverDomainEntityOutputBuilder withExternalId(UUID externalId) {
        driverDomainEntityOutput.setExternalId(externalId);
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

    public DriverDomainEntityOutput build() {
        return driverDomainEntityOutput;
    }

}
