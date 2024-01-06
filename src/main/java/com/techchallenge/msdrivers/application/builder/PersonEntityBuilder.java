package com.techchallenge.msdrivers.application.builder;


import com.techchallenge.msdrivers.repositories.driversdatabase.entity.PersonEntity;

public class PersonEntityBuilder {

    private final PersonEntity personEntity;

    public PersonEntityBuilder() {
        this.personEntity = new PersonEntity();
    }

    public PersonEntityBuilder withCpf(String cpf) {
        personEntity.setCpf(cpf);
        return this;
    }

    public PersonEntityBuilder withName(String name) {
        personEntity.setName(name);
        return this;
    }

    public PersonEntityBuilder withAge(int age) {
        personEntity.setAge(age);
        return this;
    }

    public PersonEntityBuilder withPhoneNumber(String phoneNumber) {
        personEntity.setPhoneNumber(phoneNumber);
        return this;
    }

    public PersonEntity build() {
        return personEntity;
    }
}
