package com.techchallenge.msdrivers.application.builder.driver;


import com.techchallenge.msdrivers.domain.entity.driver.CustomDriverDomainEntityOutput;

import java.time.LocalDateTime;
import java.util.UUID;

public class CustomDriverDomainEntityOutputBuilder {

    private final CustomDriverDomainEntityOutput driverDomainEntityOutput;

    public CustomDriverDomainEntityOutputBuilder() {
        driverDomainEntityOutput = new CustomDriverDomainEntityOutput();
    }

    public CustomDriverDomainEntityOutputBuilder withExternalId(UUID externalId) {
        driverDomainEntityOutput.setExternalId(externalId);
        return this;
    }

    public CustomDriverDomainEntityOutputBuilder withName(String name) {
        driverDomainEntityOutput.setName(name);
        return this;
    }

    public CustomDriverDomainEntityOutputBuilder withCreatedAt(LocalDateTime createdAt) {
        driverDomainEntityOutput.setCreatedAt(createdAt);
        return this;
    }

    public CustomDriverDomainEntityOutput build() {
        return driverDomainEntityOutput;
    }

}
