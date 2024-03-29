package com.techchallenge.msdrivers.application.builder.driver;


import com.techchallenge.msdrivers.domain.entity.driver.DriverDomainEntityInput;

public class DriverDomainEntityInputBuilder {

    private final DriverDomainEntityInput driverDomainEntityInput;

    public DriverDomainEntityInputBuilder() {
        driverDomainEntityInput = new DriverDomainEntityInput();
    }

    public DriverDomainEntityInputBuilder withCpf(String cpf) {
        driverDomainEntityInput.setCpf(cpf);
        return this;
    }

    public DriverDomainEntityInputBuilder withName(String name) {
        driverDomainEntityInput.setName(name);
        return this;
    }

    public DriverDomainEntityInputBuilder withAge(int age) {
        driverDomainEntityInput.setAge(age);
        return this;
    }

    public DriverDomainEntityInputBuilder withPhoneNumber(String phoneNumber) {
        driverDomainEntityInput.setPhoneNumber(phoneNumber);
        return this;
    }

    public DriverDomainEntityInputBuilder withAddress(String address) {
        driverDomainEntityInput.setAddress(address);
        return this;
    }

    public DriverDomainEntityInput build() {
        return driverDomainEntityInput;
    }
}
