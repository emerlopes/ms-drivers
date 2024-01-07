package com.techchallenge.msdrivers.application.builder.driver;


import com.techchallenge.msdrivers.repositories.driversdatabase.entity.DriverEntity;

public class DriverEntityBuilder {

    private final DriverEntity driverEntity;

    public DriverEntityBuilder() {
        this.driverEntity = new DriverEntity();
    }

    public DriverEntityBuilder withCpf(String cpf) {
        driverEntity.setCpf(cpf);
        return this;
    }

    public DriverEntityBuilder withName(String name) {
        driverEntity.setName(name);
        return this;
    }

    public DriverEntityBuilder withAge(int age) {
        driverEntity.setAge(age);
        return this;
    }

    public DriverEntityBuilder withPhoneNumber(String phoneNumber) {
        driverEntity.setPhoneNumber(phoneNumber);
        return this;
    }

    public DriverEntity build() {
        return driverEntity;
    }
}
